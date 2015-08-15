"""String List https://www.codeeval.com/open_challenges/38/"""

import sys


def string_list(alphabet, number):
    if number == 1:
        return list(alphabet)
    else:
        return [character + permutation for character in alphabet
                for permutation in string_list(alphabet, number - 1)]


if __name__ == '__main__':
    with open(sys.argv[1]) as test_file:
        test_cases = map(str.strip, filter(None, test_file))
        for test_case in test_cases:
            number, string = test_case.split(",")
            print ",".join(sorted(string_list(set(string), int(number))))
