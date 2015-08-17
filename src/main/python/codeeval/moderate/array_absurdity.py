"""Array Absurdity https://www.codeeval.com/open_challenges/41/"""

import collections
import sys

SIZE_SEPARATOR = ";"
ITEM_SEPARATOR = ","


def get_duplicate_entry(items):
    counter = collections.Counter(items)
    item, __ = counter.most_common(1)[0]
    return item


def parse_arguments(string):
    size, items = string.split(SIZE_SEPARATOR)
    items = (int(item) for item in items.split(ITEM_SEPARATOR))

    return int(size), items


if __name__ == "__main__":
    with open(sys.argv[1]) as test_file:
        # Suppress appearance of \n characters
        test_cases = (test_case.rstrip() for test_case in test_file)
        for test_case in test_cases:
            size, items = parse_arguments(test_case)
            print get_duplicate_entry(items)
