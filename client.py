"""Name - Ashish.P.Ransing
   Roll no - 42557
   Batch - B4
   Practical_2 - Design a distributed application using RMI for remote computation where client submits two strings to
                 the server and server returns the concatenation of the given strings."""


import Pyro4


def main():
    uri = input("Enter the server's URI: ")

    concatenator = Pyro4.Proxy(uri)

    str1 = input("Enter the first string: ")
    str2 = input("Enter the second string: ")

    result = concatenator.concatenate(str1, str2)

    print("Concatenated string:", result)


if __name__ == "__main__":
    main()
