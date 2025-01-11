
#include <string>
using namespace std;

class Solution {

public:
    bool canConstruct(string input, int targetNumberOfPalindromes) const {
        if (input.length() <= targetNumberOfPalindromes) {
            return input.length() == targetNumberOfPalindromes;
        }

        int bitStampForNumberOfOccurencesOfLettersWithOddFrequency = 0;
        for (const auto& letter : input) {
            bitStampForNumberOfOccurencesOfLettersWithOddFrequency ^= 1 << (letter - 'a');
        }

        int numberOfOccurencesOfLettersWithOddFrequency = 0;
        while (bitStampForNumberOfOccurencesOfLettersWithOddFrequency > 0) {
            numberOfOccurencesOfLettersWithOddFrequency += bitStampForNumberOfOccurencesOfLettersWithOddFrequency & 1;
            bitStampForNumberOfOccurencesOfLettersWithOddFrequency >>= 1;
        }

        return numberOfOccurencesOfLettersWithOddFrequency <= targetNumberOfPalindromes;
    }
};
