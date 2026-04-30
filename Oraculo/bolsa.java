public class bolsa {
    item item;

    public bolsa() {
    }

    void equipar() {
        if (item != null) {
            item.equipado = true;
        }
    }

    void desequipar() {
        if (item != null) {
            item.equipado = false;
        }
    }
}
