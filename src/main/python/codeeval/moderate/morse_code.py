"""Morse Code https://www.codeeval.com/open_challenges/116/"""

import sys

LETTER_SEPARATOR = " "
WORD_SEPARATOR = "  "
MORSE_CODE = {
    ".-": "A",
    "-...": "B",
    "-.-.": "C",
    "-..": "D",
    ".": "E",
    "..-.": "F",
    "--.": "G",
    "....": "H",
    "..": "I",
    ".---": "J",
    "-.-": "K",
    ".-..": "L",
    "--": "M",
    "-.": "N",
    "---": "O",
    ".--.": "P",
    "--.-": "Q",
    ".-.": "R",
    "...": "S",
    "-": "T",
    "..-": "U",
    "...-": "V",
    ".--": "W",
    "-..-": "X",
    "-.--": "Y",
    "--..": "Z",
    "-----": "0",
    ".----": "1",
    "..---": "2",
    "...--": "3",
    "....-": "4",
    ".....": "5",
    "-....": "6",
    "--...": "7",
    "---..": "8",
    "----.": "9",
}


def decode_word(morse_word):
    letters = morse_word.split(LETTER_SEPARATOR)
    return "".join(MORSE_CODE[letter] for letter in letters)


def decode_text(morse_text):
    words = morse_text.split(WORD_SEPARATOR)
    return " ".join(decode_word(word) for word in words)


if __name__ == "__main__":
    with open(sys.argv[1]) as test_file:
        # Suppress appearance of \n characters
        test_cases = (test_case.rstrip() for test_case in test_file)
        for test_case in test_cases:
            print decode_text(test_case)
