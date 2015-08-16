"""Armstrong Numbers https://www.codeeval.com/open_challenges/82/"""

import sys


def is_armstrong_number(number):
    number_string = str(number)
    digits = (int(digit) for digit in number_string)
    digits_count = len(number_string)

    sum1 = sum(digit ** digits_count for digit in digits)
    return number == sum1


if __name__ == "__main__":
    with open(sys.argv[1]) as test_file:
        # Suppress appearance of \n characters
        test_cases = (test_case.rstrip() for test_case in test_file)
        for test_case in test_cases:
            print is_armstrong_number(int(test_case))
