"""Even Numbers https://www.codeeval.com/open_challenges/100/"""

import sys


def is_even(number):
    return number % 2 == 0


def parse_arguments(string):
    return int(string)


if __name__ == "__main__":
    with open(sys.argv[1]) as test_file:
        # Suppress appearance of \n characters
        test_cases = (test_case.rstrip() for test_case in test_file)
        for test_case in test_cases:
            print 1 if is_even(parse_arguments(test_case)) else 0
