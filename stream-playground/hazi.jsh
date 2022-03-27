import brickset.LegoSet;
import repository.Repository;

import java.util.OptionalLong;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
    public class LegoSetRepository extends Repository<LegoSet> {
        public LegoSetRepository() {
            super(LegoSet.class, "brickset.json");
        }


        /**
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
         * Return how many pieces make up the most pieces set.
         *
         * @param space pieces of the product
         * @return the number of the biggest product pieces
         */
        public long themeIsSpace(String space) {
            return getAll().stream()
                    .filter(legoSet -> legoSet.getTheme() == "Space")
                    .count();
        }


        public static void main(String[] args) {
            var repository = new LegoSetRepository();
            System.out.println(repository.numberOfPackaging("Microscale"));
            System.out.println(repository.mostOfThePieces("Microscale"));
        }
    }
