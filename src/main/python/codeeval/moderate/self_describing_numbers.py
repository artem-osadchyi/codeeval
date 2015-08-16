"""Self Describing Numbers https://www.codeeval.com/open_challenges/40/"""

import collections
import sys


def is_self_describing(number):
    number = number if isinstance(number, str) else str(number)
    digits_count = collections.Counter(number)
    for position in range(len(number)):
        digit = int(number[position])
        if digit != digits_count[str(position)]:
            return False

    return True


if __name__ == "__main__":
    with open(sys.argv[1]) as test_file:
        # Suppress appearance of \n characters
        test_cases = (test_case.rstrip() for test_case in test_file)
        for test_case in test_cases:
            print 1 if is_self_describing(test_case) else 0
