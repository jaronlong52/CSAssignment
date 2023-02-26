/******************************************************************************
* A <code>CharacterArray</code> is an array (a sequential list) of char values.
* A <code>CharacterArray</code> is immutable, meaning changing the 
* <code>CharacterArray</code> will result in creation of a new 
* <code>CharacterArray</code> representing the result of the changes.
*
* @author CS 2440, Jonathan Fielder
*
* @version February 17, 2023
*
******************************************************************************/
public class CharacterArray {

	private char[] characters;

    /**
	 * Allocates a new CharacterArray so that it represents the
	 * sequence of <code>char</code> values currently contained in the 
	 * <code>char[]</code> argument. The contents of the character array 
	 * are copied; subsequent modification of the character array does
	 * not affect the newly created CharacterArray.
	 * 
	 * <b>Precondition:</b>
	 *   value is not null
	 * <b>Postcondition:</b>
	 *   the new CharacterArray object contains a copy of array value
	 * 
	 * @param value The initial value of the CharacterArray.
	 * 
	 * @throws NullPointerException when value is null
	 */
	public CharacterArray(char[] value) throws NullPointerException
	{
		characters = value.clone();
	}
	
    /**
     * Returns the <code>char</code> value at the specified index.  An index 
     * ranges from zero to <code>length() - 1</code>.  The first <code>char</code>
     * value of the sequence is at index zero, the next at index one, and so on,
     * as with array indexing.
     * 
	 * <b>Precondition:</b>
	 *   index >= 0 and < length
	 * 
     *
     * @param index the index of the <code>char</code> value to be returned
	 * 
     * @return  the specified <code>char</code> value
     *
     * @throws  IndexOutOfBoundsException
     *          if the <code>index</code> argument is negative or not less than
     *          <code>length()</code>
     */
	public char charAt(int index) throws IndexOutOfBoundsException
	{
		if (index <0 || index >= characters.length)
		{
			throw new IndexOutOfBoundsException( "Index " + index + " is out of bounds");
		}
		return characters[index];
	}

	/**
	 * Compares two CharacterArrays lexicographically. The result will be negative
	 * when the character sequence from the current CharacterArray lexicographically
	 * proceeds the character sequence from the input CharacterArray; positive when
	 * the character sequence from the input CharacterArray lexicogrphically proceeds
	 * the character sequence from the input CharacterArray; and zero otherwise.
	 * 
	 * 
	 * 
	 * @param other the CharacterArray to be compared
	 * 
	 * @return a negative integer, zero, or a positive integer when the CharacterArray
	 * 		   parameter is greater than, equal to, or less than this CharacterArray
	 */
	public int compareTo(CharacterArray other)
	{
		// set index max to shortest array
		int indexMax = 0;
		// if other is shortest
		if (this.length() > other.length())
		{
			indexMax = other.length();
		}
		// if this array is shortest or they are equal
		else
		{
			indexMax = this.length();
		}
		// check if entry is diff for each index, if it is return difference
		for (int i = 0; i < indexMax; i++)
		{
			if(this.charAt(i) != other.charAt(i))
			{
				return this.charAt(i) - other.charAt(i);
			}
		}

		// if index entrys same but length different
		if (this.length() != other.length())
		{
			return this.length() - other.length();
		}
		// if no difference
		return 0;				
	}
	
	/**
	 * Compares two CharacterArrays lexicographically, ignoring case differences.
	 * This method returns an integer whose sign is that of calling compareTo with
	 * a version of each CharacterArray where all cases differences have been
	 * eliminated by calling Character.toUpperCase(Character.toLowerCase(c)) on
	 * each character c.
	 * 
	 * 
	 * 
	 * @param other the CharacterArray to be compared
	 * 
	 * @return a negative integer, zero, or a positive integer when the CharacterArray
	 * 		   parameter is greater than, equal to, or less than this CharacterArray,
	 * 		   ignoring case
	 */
	public int compareToIgnoreCase(CharacterArray other)
	{
		
		return this.toLowerCase().compareTo(other.toLowerCase());				
	}
	
	/**
	 * Compares this CharacterArray with other. other is considered equal to this
	 * CharacterArray if other instanceOf CharacterArray is true, if they are the
	 * same length, and if the corresponding characters are equal
	 * 
	 * 
	 *  
	 * @param other The CharacterArray to compare this CharacterArray against
	 * 
	 * @return true if the input is not null, is a CharacterArray of the same length,
	 *         and if corresponding characters in each CharacterArray are equal
	 */
	@Override
	public boolean equals(Object other)
	{
		if (other instanceof CharacterArray)
		{
			if (other != null && this != null)
			{
				if(this.compareTo((CharacterArray) other) == 0)
				{
					return true;
				}
			}
		}
		return false;		
	}
	
	/**
	 * Compares this CharacterArray with other, ignoring the case of each
	 * character. Two CharacterArrays are considered equal if they are the
	 * same length, and if the corresponding characters are equal, disregarding
	 * case (i.e., if, for characters a and b, 
	 * Character.toUpperCase(Character.toLowerCase(a)) == 
	 * Character.toUpperCase(Character.toLowerCase(b))
	 * 
	 * 
	 *  
	 * @param other The CharacterArray to compare this CharacterArray against
	 * 
	 * @return true if the input is not null, is a CharacterArray of the same length,
	 *         and if corresponding characters in each CharacterArray are equal
	 *         disregarding case
	 */
	public boolean equalsIgnoreCase(CharacterArray other)
	{
		return this.toLowerCase().equals(other.toLowerCase());
	}
	
	/**
	 * Returns the index within this CharacterArray of the first occurrence
	 * of the specified character. If ch does not occur in this CharacterArray, 
	 * -1 is returned.
	 * 
	 * 
	 * 
	 * @param ch a character
	 * 
	 * @return the index of the first occurrence of the character in the
	 * 		   CharacterArray, or -1 if the character does not occur.
	 */
	public int indexOf(char ch)
	{
		for (int i = 0; i < characters.length; i++)
		{
			if (characters[i] == ch)
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns true if, and only if, length() is 0.
	 * 
	 * 
	 * 
	 * @return true if length() is 0, otherwise false
	 */
	public boolean isEmpty()
	{
		if (this.length() == 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the index within this CharacterArray of the last occurrence
	 * of the specified character. If ch does not occur in this CharacterArray, 
	 * -1 is returned.
	 * 
	 * 
	 * 
	 * @param ch a character
	 * 
	 * @return the index of the last occurrence of the character in the
	 * 		   CharacterArray, or -1 if the character does not occur.
	 */
	public int lastIndexOf(char ch)
	{
		for (int i = this.length() - 1; i >= 0; i --)
		{
			if (this.charAt(i) == ch)
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns the length of this CharacterArray. The length is equal to the
	 * number of characters in the CharacterArray.
	 * 
	 * 
	 * 
	 * @return the length of the CharacterArray
	 */
	public int length()
	{
		return this.characters.length;
	}
	
	/**
	 * Returns a CharacterArray resulting from replacing all occurrences of
	 * oldChar in this CharacterArray with newChar.
	 * 
	 * If the character oldChar does not occur in the CharacterArray, then
	 * a reference to the current CharacterArray object is returned. Otherwise,
	 * a new CharacterArray object is returned that represents an array of characters
	 * identical to the current CharacterArray, except with every occurrence
	 * of oldChar replaced with newChar.
	 * 
	 * 
	 * 
	 * @param oldChar the old character
	 * @param newChar the new character
	 * 
	 * @return a CharacterArray with every occurrence of oldChar replaced with newChar
	 */
	public CharacterArray replace(char oldChar, char newChar)
	{
		// check if contains oldChar
		if (indexOf(oldChar) == -1)
		{
			return this;
		}

		// clone characters to new char[] to work with
		char[] target = characters.clone();

		for (int i = 0; i < target.length; i++)
		{
			if (target[i] == oldChar)
			{
				target[i] = newChar;
			}
		}
		// expecting CharacterArray, new CharacterArray with target as arg
		return new CharacterArray(target);
	}

	/**
	 * Returns a new CharacterArray object with the same contents as the current
	 * CharacterArray, but with each character converted to lower case using
	 * Character.toLowerCase()
	 * 
	 * 
	 * 
	 * @return the CharacterArray, converted to lower case
	 */
	public CharacterArray toLowerCase()
	{
		CharacterArray thisLower = this.clone();
		for (int i = 0; i < thisLower.length(); i++)
		{
			thisLower.characters[i] = Character.toLowerCase(this.charAt(i));
		}
		return thisLower;
	}
	
	/**
	 * Returns a new CharacterArray object with the same contents as the current
	 * CharacterArray, but with each character converted to upper case using
	 * Character.toUpperCase()
	 * 
	 * 
	 * 
	 * @return the CharacterArray, converted to upper case
	 */
	public CharacterArray toUpperCase()
	{
		CharacterArray thisUpper = this.clone();
		for (int i = 0; i < thisUpper.length(); i++)
		{
			thisUpper.characters[i] = Character.toUpperCase(this.charAt(i));
		}
		return thisUpper;
	}	
	
	/**
	 * Returns a CharacterArray whose value is this CharacterArray, but with
	 * leading and trailing whitespace removed. If there is no leading or
	 * trailing whitespace, a reference to the current CharacterArray is
	 * returned instead. A character c is considered to be whitespace if
	 * Character.isWhitespace(c) returns true.
	 * 
	 * 
	 * 
	 * @return the CharacterArray, with leading and trailing whitespace removed
	 */
	public CharacterArray trim()
	{
		if (Character.isWhitespace(this.characters[0]) || Character.isWhitespace(this.characters[this.characters.length-1]))
		{
			int start = 0;
			int end = this.characters.length - 1;
			
			// finds first non space
			while (Character.isWhitespace(this.characters[start]))
			{
				start++;
				if (start > end)
				{
					char[] empty = new char[0];
					return new CharacterArray(empty);
				}
			}

			// finds last non space
			while (Character.isWhitespace(this.characters[end]))
			{
				end--;
			}

			char[] trimmedData = new char[end + 1 - start];


			for (int i = 0; i < trimmedData.length; i++)
			{
				trimmedData[i] = this.characters[start];
				start++;
			}
			return new CharacterArray(trimmedData);
			
			

		}
		return this;
	}
	
	/**
	 * Returns a CharacterArray where the characters appear in reverse order.
	 * 
	 * 
	 * 
	 * @return a CharacterArray with characters in the reverse order
	 */
	public CharacterArray reverse()
	{
		char[] target = new char[characters.length];
		int j = characters.length - 1;
		for (int i = 0; i <= target.length; i++)
		{
			target[i] = characters[j];
			j--;
		}
		return new CharacterArray(target);		
	}

	/**
	 * Returns a new CharacterArray that contains the same characters in the
	 * same order.
	 * 
	 * 
	 * 
	 * @return a CharacterArray that contains the same characters in the same order
	 */
	@Override
	public CharacterArray clone()
	{
		CharacterArray thisClone = new CharacterArray(this.characters);
		return thisClone;
	}
	
	/**
	 * Returns a String representation of this class. The string representation
	 * consists of a list of characters, in the order they are stored in the array,
	 * and with no whitespace between adjacent elements. 
	 * 
	 * 
	 * 
	 * @return a String representation of the CharacterArray 
	 */
	@Override
	public String toString()
	{
		String result = "";
		for (int i = 0; i < characters.length; i++)
		{
			result += characters[i];
		}
		return result;
	}



	
}
