#Vijay Venkatesan
#October 17, 2022
#Python program that plays a version of hangman called spaceman with the user

import random

def get_random_word(list_words):
    '''
    selects a random word from a list of words and returns it back to the caller
    uses a list as a parameter
    returns a string to the caller
    '''

    random_number = random.randint(0,19)
    return list_words[random_number]

def get_hidden_word(random_word):
    '''
    takes the random word and determines how many characters are in it
    creates a string that is made up entirely of underscores
    The string is the same number of characters as the random word
    uses a string as a parameter
    returns a string
    '''

    length = len(random_word)
    hidden_word = "_ " * length
    return hidden_word

def add_letter(guess, char_list):
    '''
    adds the guessed letter to the list of guessed letters
    uses a string and list parameter
    returns a list of the guessed letters
    '''
    if guess in char_list:
        return char_list
    else:
        char_list.append(guess)
        return char_list

def character_placement(random_word, guessed_letters):
    '''
    creates a new word by going through each index of the random word
    uses a string and list parameter
    returns a string
    '''
    new_word = ""

    index = 0
    while index < len(random_word):
        if random_word[index] in guessed_letters:
            new_word += random_word[index]
        else:
            new_word += "_"
        index += 1
    
    return new_word

def get_status(new_word, random_word):
    '''
    compares the new word and random word to see if they are the same
    uses two strings as parameters
    returns a string
    '''

    if new_word == random_word : 
        return "Good Job, You win!"
    else:
        return "Sorry, You lose!"

def main():
    words = ["donuts", "terms", "mirror", "atmosphere", "stroke",
    "desert", "qualified", "biscuit", "marine", "monopoly",
    "writer", "arrest", "monarch", "credit", "product",
    "donkey", "liquids", "established", "eagle", "reason"]

    random_word = get_random_word(words)
    hidden_word = get_hidden_word(random_word)

    print("Here is the hidden word : \n",hidden_word)

    wrong_count = 0
    guessed_letters = []
    new_word = hidden_word

    while wrong_count <= 5 and new_word != random_word:
        guess = input("Please enter a letter : ")

        if guess not in random_word and guess not in guessed_letters:
            wrong_count += 1
            guessed_letters = add_letter(guess, guessed_letters)
            print(new_word)
        elif guess not in random_word and guess in guessed_letters:
            print("Letter has already been guessed before")
        else:
            guessed_letters = add_letter(guess, guessed_letters)
            new_word = character_placement(random_word, guessed_letters)
            print("Here is the updated hidden word : ", new_word)
    
    status = get_status(new_word, random_word)
    print(status)

if __name__ == "__main__":
    main()




