package be.kdg.nerdle.model.randomformulagenerator;

import org.mariuszgromada.math.mxparser.License;

public class Main {
    public static void main(String[] args) {
        License.iConfirmNonCommercialUse("bobby");
        GeneratorWithTemplates generator = new GeneratorWithTemplates();
        generator.GenerateFormulas(366);
    }
}
