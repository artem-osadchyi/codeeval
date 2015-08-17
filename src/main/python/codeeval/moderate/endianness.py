"""Endianness https://www.codeeval.com/open_challenges/15/"""

import sys


def get_endian():
    return "%sEndian" % sys.byteorder.title()


if __name__ == "__main__":
    print get_endian()
