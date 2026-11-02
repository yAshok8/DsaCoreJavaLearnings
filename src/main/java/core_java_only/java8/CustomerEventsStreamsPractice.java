package core_java_only.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomerEventsStreamsPractice {

    static class Event {
        String transactionId;
        String customerId;
        String status; // POSTED or REVERSED
        long timestamp;
        long amountCents;

        Event(String transactionId,
              String customerId,
              String status,
              long timestamp,
              long amountCents) {
            this.transactionId = transactionId;
            this.customerId = customerId;
            this.status = status;
            this.timestamp = timestamp;
            this.amountCents = amountCents;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public long getAmountCents() {
            return amountCents;
        }

        public void setAmountCents(long amountCents) {
            this.amountCents = amountCents;
        }
    }

    static List<String> topCustomers(List<Event> events, int k) {

        //1. Select the latest event for each transactionId by greatest timestamp.
        // On equal timestamps, the event appearing later in the input wins.

        Map<String, Event> latestEventsPerTransaction = events.stream()
                .collect(Collectors.toMap(
                        event -> event.transactionId,
                        Function.identity(),
                        (e1, e2) -> {
                            if (e1.timestamp != e2.timestamp) {
                                return e1.timestamp > e2.timestamp ? e1 : e2;
                            }
                            return e2;
                }));

        //2. Keep only transactions whose selected event is POSTED.
        List<Event> postedEvents = latestEventsPerTransaction.values()
                .stream().filter(event -> event.status.equals("POSTED"))
                .collect(Collectors.toList());

        //3. Sum their selected amounts per customer using long.
        // A reversed transaction contributes nothing; do not subtract it from another transaction.
        Map<String, Long> totalSumPerCustomer = postedEvents.stream()
                .collect(Collectors.groupingBy(e -> e.customerId, Collectors.summingLong(e -> e.amountCents)));

        //Return at most k strings in the form `customerId:totalCents`,
        // sorted by total descending, then customerId ascending lexicographically.
        return totalSumPerCustomer.entrySet().stream()
//                .sorted(Comparator.comparing((Map.Entry<String, Long> e) -> e.getValue(), Comparator.reverseOrder()).thenComparing(Map.Entry::getKey))
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry::getKey))
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .limit(k)
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {

        List<Event> events = Arrays.asList(
            new Event("T1", "C1", "POSTED",   100, 1000),
            new Event("T2", "C2", "POSTED",   120, 2000),
            new Event("T1", "C1", "REVERSED", 150, 1000),
            new Event("T3", "C1", "POSTED",   180, 3000),
            new Event("T4", "C3", "POSTED",   200, 1500),
            new Event("T2", "C2", "POSTED",   220, 2500)
        );

        int k = 3;

        List<String> result = topCustomers(events, k);

        System.out.println(result);
    }
}