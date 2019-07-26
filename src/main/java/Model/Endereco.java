package Model;

public class Endereco {
    private String regiao;
    private String siglaEstado;
    private String siglaMunicipio;

    public Endereco(String regiao, String siglaEstado, String siglaMunicipio) {
        this.regiao = regiao;
        this.siglaEstado = siglaEstado;
        this.siglaMunicipio = siglaMunicipio;
    }

    public Endereco(){}

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public String getSiglaMunicipio() {
        return siglaMunicipio;
    }

    public void setSiglaMunicipio(String siglaMunicipio) {
        this.siglaMunicipio = siglaMunicipio;
    }
}
