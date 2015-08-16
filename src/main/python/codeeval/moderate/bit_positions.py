"""Bit Positions https://www.codeeval.com/open_challenges/19/"""

import sys

INDEX_BASE = 1
ARGUMENT_SEPARATOR = ","


def are_bits_equal(number, p0, p1):
    # Trim leading 0b prefix
    bits = bin(number)[2:]
    return bits[p0 - INDEX_BASE] == bits[p1 - INDEX_BASE]


def parse_arguments(string):
    number, p0, p1 = string.split(ARGUMENT_SEPARATOR)
    return int(number), int(p0), int(p1)


if __name__ == "__main__":
    with open(sys.argv[1]) as test_file:
        # Suppress appearance of \n characters
        test_cases = (test_case.rstrip() for test_case in test_file)
        for test_case in test_cases:
            result = are_bits_equal(*parse_arguments(test_case))
            print str(result).lower()
