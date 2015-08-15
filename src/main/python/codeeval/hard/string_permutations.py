"""String Permutations https://www.codeeval.com/open_challenges/14/"""

import sys


def permutations(string):
    if len(string) == 2:
        return [string, string[::-1]]
    else:
        return [character + permutation
                for index, character in enumerate(string)
                for permutation in permutations(without(string, index))]


def without(sequence, index):
    return sequence[:index] + sequence[index + 1:]


if __name__ == '__main__':
    with open(sys.argv[1]) as test_file:
        test_cases = map(str.strip, filter(None, test_file))
        for test_case in test_cases:
            print ",".join(sorted(permutations(test_case)))
