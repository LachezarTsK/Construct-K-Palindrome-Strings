
using System;

public class Solution
{
    public bool CanConstruct(string input, int targetNumberOfPalindromes)
    {
        if (input.Length <= targetNumberOfPalindromes)
        {
            return input.Length == targetNumberOfPalindromes;
        }

        int bitStampForNumberOfOccurencesOfLettersWithOddFrequency = 0;
        foreach (char letter in input)
        {
            bitStampForNumberOfOccurencesOfLettersWithOddFrequency ^= 1 << (letter - 'a');
        }

        int numberOfOccurencesOfLettersWithOddFrequency = 0;
        while(bitStampForNumberOfOccurencesOfLettersWithOddFrequency > 0) {
            numberOfOccurencesOfLettersWithOddFrequency += bitStampForNumberOfOccurencesOfLettersWithOddFrequency & 1;
            bitStampForNumberOfOccurencesOfLettersWithOddFrequency >>= 1;
        }

        return numberOfOccurencesOfLettersWithOddFrequency <= targetNumberOfPalindromes;
    }
}
