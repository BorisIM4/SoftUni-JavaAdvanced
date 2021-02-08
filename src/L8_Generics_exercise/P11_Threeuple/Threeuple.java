package L8_Generics_exercise.P11_Threeuple;

public class Threeuple<K, V, P> {
    private K firstElement;
    private V secondElement;
    private P thirdElement;

    public Threeuple(K firstElement, V secondElement, P thirdElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.thirdElement = thirdElement;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s"
                , this.firstElement
                , this.secondElement
                , this.thirdElement);
    }
}
