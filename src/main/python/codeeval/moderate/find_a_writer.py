"""Find a Writer https://www.codeeval.com/open_challenges/97/"""

import sys

ARGUMENT_SEPARATOR = "| "
LIST_SEPARATOR = " "
INDEX_BASE = 1


def decode(encoded_string, indices):
    return "".join(encoded_string[index - INDEX_BASE] for index in indices)


def parse_arguments(string):
    encoded_string, indices = string.split(ARGUMENT_SEPARATOR)
    indices = map(int, indices.split(LIST_SEPARATOR))

    return encoded_string, indices


if __name__ == "__main__":
    with open(sys.argv[1]) as test_file:
        # Suppress appearance of \n characters
        test_cases = (test_case.rstrip() for test_case in test_file)
        for test_case in test_cases:
            print decode(*parse_arguments(test_case))
