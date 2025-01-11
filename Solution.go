
package main

import "fmt"

func canConstruct(input string, targetNumberOfPalindromes int) bool {
    if len(input) <= targetNumberOfPalindromes {
        return len(input) == targetNumberOfPalindromes
    }

    bitStampForNumberOfOccurencesOfLettersWithOddFrequency := 0
    for _, letter := range input {
        bitStampForNumberOfOccurencesOfLettersWithOddFrequency ^= 1 << (letter - 'a')
    }

    numberOfOccurencesOfLettersWithOddFrequency := 0
    for bitStampForNumberOfOccurencesOfLettersWithOddFrequency > 0 {
        numberOfOccurencesOfLettersWithOddFrequency += bitStampForNumberOfOccurencesOfLettersWithOddFrequency & 1
        bitStampForNumberOfOccurencesOfLettersWithOddFrequency >>= 1
    }

    return numberOfOccurencesOfLettersWithOddFrequency <= targetNumberOfPalindromes
}
