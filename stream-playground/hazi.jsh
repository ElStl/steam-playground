import brickset.LegoSet;
import repository.Repository;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalLong;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
    public class LegoSetRepository extends Repository<LegoSet> {
        public LegoSetRepository() {
            super(LegoSet.class, "brickset.json");
        }
        /**
         * 1.
         * Return how many types of package is exist.
         *
         * @param pack packaging of the product
         * @return the number how many package is existing
         */
        public long numberOfPackaging(String pack) {
            return getAll().stream()
                    .flatMap(legoSet -> legoSet.getPackagingType().describeConstable().stream())
                    .distinct()
                    .count();
        }
        /**
         * 2.
         * Return how many pieces make up the most pieces set.
         *
         * @param piece pieces of the product
         * @return the number of the biggest product pieces
         */
        public OptionalLong mostOfThePieces(String piece) {
            return getAll().stream()
                    .mapToLong(LegoSet::getPieces)
                    .max();
        }
        /**
         * 3.
         * Return how many pieces make up the most pieces set.
         *
         * @param longest pieces of the product
         * @return the number of the biggest product pieces
         */
        public Optional<String> longestName(String longest) {
            return Optional.of(getAll().stream()
                    .map(LegoSet::getName)
                    .max(Comparator.comparingInt(String::length))
                    .get());
        }
        /**
         * 4.
         * Return where the theme is start with the letter "M".
         *
         * @param first pieces of the product
         * @return the number of the biggest product pieces
         */
        public long startsWith(String first) {
            return getAll().stream()
                    .filter(legoSet -> legoSet.getTheme().startsWith("M"))
                    .count();
        }
        /**
         * 5.
         * Return the product which is less than 500 pieces.
         *
         * @param less pieces of the product
         * @return the number of the biggest product pieces
         */
        public long lessThanFivehundred(String less) {
            return getAll().stream()
                    .filter(legoSet -> legoSet.getPieces() < 500)
                    .map(LegoSet::getName)
                    .forEach(System.out::println);
        }

        public static void main(String[] args) {
            var repository = new LegoSetRepository();
            System.out.println(repository.numberOfPackaging("pack"));
            System.out.println(repository.mostOfThePieces("piece"));
            System.out.println(repository.longestName("longest"));
            System.out.println(repository.startsWith("first"));
            System.out.println(repository.lessThanFivehundred("less"));
        }
    }
