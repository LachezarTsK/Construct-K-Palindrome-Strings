
public class Solution {

    public boolean canConstruct(String input, int targetNumberOfPalindromes) {
        if (input.length() <= targetNumberOfPalindromes) {
            return input.length() == targetNumberOfPalindromes;
        }

        int bitStampForNumberOfOccurencesOfLettersWithOddFrequency = 0;
        for (char letter : input.toCharArray()) {
            bitStampForNumberOfOccurencesOfLettersWithOddFrequency ^= 1 << (letter - 'a');
        }

        int numberOfOccurencesOfLettersWithOddFrequency = 0;
        while (bitStampForNumberOfOccurencesOfLettersWithOddFrequency > 0) {
            numberOfOccurencesOfLettersWithOddFrequency += bitStampForNumberOfOccurencesOfLettersWithOddFrequency & 1;
            bitStampForNumberOfOccurencesOfLettersWithOddFrequency >>= 1;
        }

        return numberOfOccurencesOfLettersWithOddFrequency <= targetNumberOfPalindromes;
    }
}
