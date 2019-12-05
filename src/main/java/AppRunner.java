import service.Service;

public class AppRunner {
    public static void main(String[] args) {

        int[] input = new int[] {1,3,56,8,0,2,3,64,12,44,21,1, 9};
        new Service().start(input);
    }
}
