public class denMenDeniki{
public static void main(String[] args) {
    int a = 1;
    int b = 2;
    int c = calc(a, b);
}
static int calc(int a, int b) {
    return (int) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
}
}