package be.kdg.nerdle.model.randomformulagenerator;

import org.mariuszgromada.math.mxparser.License;

public class Main {
    public static void main(String[] args){
        License.iConfirmNonCommercialUse("shut up"); // only way to make mXparser shut the hell up about licenses (and it still doesn't fully shut up)
        GeneratorWithTemplates test = new GeneratorWithTemplates();
        test.GenerateFormulas(366);
    }
}
