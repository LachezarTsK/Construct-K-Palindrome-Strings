
function canConstruct(input: string, targetNumberOfPalindromes: number): boolean {
    if (input.length <= targetNumberOfPalindromes) {
        return input.length === targetNumberOfPalindromes;
    }
    const ASCII_SMALL_CASE_A = 97;

    let bitStampForNumberOfOccurencesOfLettersWithOddFrequency = 0;
    for (let i = 0; i < input.length; ++i) {
        bitStampForNumberOfOccurencesOfLettersWithOddFrequency ^= 1 << (input.codePointAt(i) - ASCII_SMALL_CASE_A);
    }

    let numberOfOccurencesOfLettersWithOddFrequency = 0;
    while (bitStampForNumberOfOccurencesOfLettersWithOddFrequency > 0) {
        numberOfOccurencesOfLettersWithOddFrequency += bitStampForNumberOfOccurencesOfLettersWithOddFrequency & 1;
        bitStampForNumberOfOccurencesOfLettersWithOddFrequency >>= 1;
    }

    return numberOfOccurencesOfLettersWithOddFrequency <= targetNumberOfPalindromes;
};
