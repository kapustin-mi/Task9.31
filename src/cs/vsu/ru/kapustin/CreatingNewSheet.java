package cs.vsu.ru.kapustin;

import java.util.ArrayList;
import java.util.List;

public class CreatingNewSheet {

    public List<Integer> createNewList(List<Integer> list) {
        int maxOfRepetitions, repetitionsOfAddedNumbers = 999999;
        List<Integer> addedNumbers;
        List<Integer> newList = new ArrayList<>();

        while (list.size() != newList.size()) {
            maxOfRepetitions = findMaxNumberOfRepetitions(list, repetitionsOfAddedNumbers);
            addedNumbers = findNumbersWithMaxRepeatability(list, maxOfRepetitions);

            sortWithGivenRepetitions(addedNumbers);
            newList.addAll(addedNumbers);

            repetitionsOfAddedNumbers = maxOfRepetitions;
        }

        return newList;
    }

    private int findMaxNumberOfRepetitions(List<Integer> list, int repetitionsOfAddedNumbers) {
        int repetitionsOfNewNumber, maxOfRepetitions = 0;

        for (Integer number : list) {
            repetitionsOfNewNumber = findNumberOfRepetitions(list, number);

            if (repetitionsOfNewNumber > maxOfRepetitions && repetitionsOfNewNumber < repetitionsOfAddedNumbers) {
                maxOfRepetitions = repetitionsOfNewNumber;
            }
        }

        return maxOfRepetitions;
    }

    private int findNumberOfRepetitions(List<Integer> list, int number) {
        int repetitions = 0;

        for (Integer member : list) {
            if (member == number) {
                repetitions++;
            }
        }

        return repetitions;
    }

    private List<Integer> findNumbersWithMaxRepeatability(List<Integer> list, int maxOfRepetitions) {
        int repetitionsOfNewNumber;
        List<Integer> addedNumbers = new ArrayList<>();

        for (Integer number : list) {
            repetitionsOfNewNumber = findNumberOfRepetitions(list, number);

            if (repetitionsOfNewNumber == maxOfRepetitions) {
                addedNumbers.add(number);
            }
        }

        return addedNumbers;
    }

    private void sortWithGivenRepetitions(List<Integer> list) {
        int tmp;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(i)) {
                    tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
    }
}

