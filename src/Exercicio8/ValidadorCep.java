package Exercicio8;

public class ValidadorCep {
    public static void validar(String cep) {
        if (cep == null || !cep.matches("\\d{8}")) {
            throw new CepInvalidoException("CEP inválido. O formato deve ser 8 dígitos.");
        }
    }
}
