public class item {
    int idItem;
    String tipoItem;
    boolean equipado;

    public item() {
    }

    void imprimirDados() {
        String dados = "Item: " + idItem + "\n"
                + "Tipo: " + tipoItem + "\n"
                + "Equipado: " + equipado;

        System.out.println(dados);
        InOut.MsgDeInformacao("Item", dados);
    }
}
