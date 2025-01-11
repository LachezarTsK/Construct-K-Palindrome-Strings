
class Solution {

    fun canConstruct(input: String, targetNumberOfPalindromes: Int): Boolean {
        if (input.length <= targetNumberOfPalindromes) {
            return input.length == targetNumberOfPalindromes
        }

        var bitStampForNumberOfOccurencesOfLettersWithOddFrequency = 0
        for (letter in input) {
            bitStampForNumberOfOccurencesOfLettersWithOddFrequency =
                bitStampForNumberOfOccurencesOfLettersWithOddFrequency xor (1 shl (letter - 'a'))
        }

        var numberOfOccurencesOfLettersWithOddFrequency = 0
        while (bitStampForNumberOfOccurencesOfLettersWithOddFrequency > 0) {
            numberOfOccurencesOfLettersWithOddFrequency += bitStampForNumberOfOccurencesOfLettersWithOddFrequency and 1
            bitStampForNumberOfOccurencesOfLettersWithOddFrequency =
                bitStampForNumberOfOccurencesOfLettersWithOddFrequency shr 1
        }

        return numberOfOccurencesOfLettersWithOddFrequency <= targetNumberOfPalindromes
    }
}
