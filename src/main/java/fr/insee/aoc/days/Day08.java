package fr.insee.aoc.days;

import java.util.ArrayList;
import java.util.List;

import fr.insee.aoc.utils.Days;

public class Day08 implements Day {

    @Override
    public String part1(String input, Object... params) {
        String transmission = Days.readLine(input);
        int largeur = (int) params[0];
        int hauteur = (int) params[1];
        int nombrePixels = largeur*hauteur;
        List<Layer> layers = new ArrayList<>();
        int nombreLayer = transmission.length() / nombrePixels;
        
        for (int i = 0; i < nombreLayer; i++) {
            layers.add(new Layer(transmission.substring(i*nombrePixels, (i+1)*nombrePixels)
            ,largeur));
        }

        return String.valueOf(layers.stream().min((a,b)->a.numberOf(0) - b.numberOf(0))
        .map(layer -> layer.numberOf(1)*layer.numberOf(2)).get());
    }

    private class Layer {
        List<List<Integer>> pixels = new ArrayList<>();
        
        public Layer(String donnees, int largeur) {
            List<Integer> lignePixelEnCours = new ArrayList<>();
            for (char pixel : donnees.toCharArray()) {
                lignePixelEnCours.add(Character.getNumericValue(pixel));
                if (lignePixelEnCours.size() == largeur) {
                    List<Integer> lignePixel = new ArrayList<>();
                    lignePixel.addAll(lignePixelEnCours);
                    pixels.add(lignePixel);
                    lignePixelEnCours = new ArrayList<>();
                };
            };
        }

        public int numberOf(int nombreRecherche) {
            return (int) pixels
                .stream()
                .mapToLong(ligne -> ligne
                    .stream()
                    .filter(pixel -> pixel.equals(nombreRecherche))
                    .count())
                .sum();
        }

        public int getLargeur() {
            return (pixels.size() > 0) ? pixels.get(0).size() : 0;
        }


    }
}
