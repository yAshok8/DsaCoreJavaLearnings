package custom_annotations;

public class Calculator implements ICalculator {

    @CacheIt
    public int add(int num_1, int num_2) {
        return num_1 + num_2;
    }
    @CacheIt
    public int sub(int num_1, int num_2) {
        return num_1 - num_2;
    }
    @CacheIt
    public int mul(int num_1, int num_2) {
        return num_1 * num_2;
    }
    @CacheIt
    public int div(int num_1, int num_2) {
        return num_1 / num_2;
    }
}