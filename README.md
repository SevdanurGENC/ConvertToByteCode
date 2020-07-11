# ConvertToByteCode
Compile to java bytecode with using Javassist.

## License
[MIT](https://choosealicense.com/licenses/mit/)



<h2><span class="mw-headline" id="The_Java_bytecodes">Table of The Java bytecodes</span></h2>
<p>The manipulation of the operand stack is notated as [before]→[after], where [before] is the stack before the instruction is executed and [after] is the stack after the instruction is executed. A stack with the element 'b' on the top and element 'a' just after the top element is denoted 'a,b'.
</p>
<table class="wikitable">
<tbody><tr>
<th>Mnemonic</th>
<th>Opcode<br /><i>(in <a href="/w/index.php?title=Hexadecimal&amp;action=edit&amp;redlink=1" class="new" title="Hexadecimal (does not exist)">hex</a>)</i></th>
<th>Other bytes</th>
<th>Stack<br />[before]→[after]</th>
<th>Description
</th></tr>
<tr>
<th colspan="5">A
</th></tr>
<tr>
<td>aaload</td>
<td align="center">32</td>
<td></td>
<td>arrayref, index → value</td>
<td>loads onto the stack a reference from an array
</td></tr>
<tr>
<td>aastore</td>
<td align="center">53</td>
<td></td>
<td>arrayref, index, value →</td>
<td>stores a reference into an array
</td></tr>
<tr>
<td>aconst_null</td>
<td align="center">01</td>
<td></td>
<td>→ null</td>
<td>pushes a <i>null</i> reference onto the stack
</td></tr>
<tr>
<td>aload</td>
<td align="center">19</td>
<td>index</td>
<td>→ objectref</td>
<td>loads a reference onto the stack from a local variable <i>#index</i>
</td></tr>
<tr>
<td>aload_0</td>
<td align="center">2a</td>
<td></td>
<td>→ objectref</td>
<td>loads a reference onto the stack from local variable 0
</td></tr>
<tr>
<td>aload_1</td>
<td align="center">2b</td>
<td></td>
<td>→ objectref</td>
<td>loads a reference onto the stack from local variable 1
</td></tr>
<tr>
<td>aload_2</td>
<td align="center">2c</td>
<td></td>
<td>→ objectref</td>
<td>loads a reference onto the stack from local variable 2
</td></tr>
<tr>
<td>aload_3</td>
<td align="center">2d</td>
<td></td>
<td>→ objectref</td>
<td>loads a reference onto the stack from local variable 3
</td></tr>
<tr>
<td>anewarray</td>
<td align="center">bd</td>
<td>indexbyte1, indexbyte2</td>
<td>count → arrayref</td>
<td>creates a new array of references of length <i>count</i> and component type identified by the class reference <i>index</i> (<i>indexbyte1 &lt;&lt; 8 + indexbyte2</i>) in the constant pool
</td></tr>
<tr>
<td>areturn</td>
<td align="center">b0</td>
<td></td>
<td>objectref → [empty]</td>
<td>returns a reference from a method
</td></tr>
<tr>
<td>arraylength</td>
<td align="center">be</td>
<td></td>
<td>arrayref → length</td>
<td>gets the length of an array
</td></tr>
<tr>
<td>astore</td>
<td align="center">3a</td>
<td>index</td>
<td>objectref →</td>
<td>stores a reference into a local variable <i>#index</i>
</td></tr>
<tr>
<td>astore_0</td>
<td align="center">4b</td>
<td></td>
<td>objectref →</td>
<td>stores a reference into local variable 0
</td></tr>
<tr>
<td>astore_1</td>
<td align="center">4c</td>
<td></td>
<td>objectref →</td>
<td>stores a reference into local variable 1
</td></tr>
<tr>
<td>astore_2</td>
<td align="center">4d</td>
<td></td>
<td>objectref →</td>
<td>stores a reference into local variable 2
</td></tr>
<tr>
<td>astore_3</td>
<td align="center">4e</td>
<td></td>
<td>objectref →</td>
<td>stores a reference into local variable 3
</td></tr>
<tr>
<td>athrow</td>
<td align="center">bf</td>
<td></td>
<td>objectref → [empty], objectref</td>
<td>throws an error or exception (notice that the rest of the stack is cleared, leaving only a reference to the Throwable)
</td></tr>
<tr>
<th colspan="5">B
</th></tr>
<tr>
<td>baload</td>
<td align="center">33</td>
<td></td>
<td>arrayref, index → value</td>
<td>loads a byte or Boolean value from an array
</td></tr>
<tr>
<td>bastore</td>
<td align="center">54</td>
<td></td>
<td>arrayref, index, value →</td>
<td>stores a byte or Boolean value into an array
</td></tr>
<tr>
<td>bipush</td>
<td align="center">10</td>
<td>byte</td>
<td>→ value</td>
<td>pushes a <i>byte</i> onto the stack as an integer <i>value</i>
</td></tr>
<tr>
<th colspan="5">C
</th></tr>
<tr>
<td>caload</td>
<td align="center">34</td>
<td></td>
<td>arrayref, index → value</td>
<td>loads a char from an array
</td></tr>
<tr>
<td>castore</td>
<td align="center">55</td>
<td></td>
<td>arrayref, index, value →</td>
<td>stores a char into an array
</td></tr>
<tr>
<td>checkcast</td>
<td align="center">c0</td>
<td>indexbyte1, indexbyte2</td>
<td>objectref → objectref</td>
<td>checks whether an <i>objectref</i> is of a certain type, the class reference of which is in the constant pool at <i>index</i> (<i>indexbyte1 &lt;&lt; 8 + indexbyte2</i>)
</td></tr>
<tr>
<th colspan="5">D
</th></tr>
<tr>
<td>d2f</td>
<td align="center">90</td>
<td></td>
<td>value → result</td>
<td>converts a double to a float
</td></tr>
<tr>
<td>d2i</td>
<td align="center">8e</td>
<td></td>
<td>value → result</td>
<td>converts a double to an int
</td></tr>
<tr>
<td>d2l</td>
<td align="center">8f</td>
<td></td>
<td>value → result</td>
<td>converts a double to a long
</td></tr>
<tr>
<td>dadd</td>
<td align="center">63</td>
<td></td>
<td>value1, value2 → result</td>
<td>adds two doubles
</td></tr>
<tr>
<td>daload</td>
<td align="center">31</td>
<td></td>
<td>arrayref, index → value</td>
<td>loads a double from an array
</td></tr>
<tr>
<td>dastore</td>
<td align="center">52</td>
<td></td>
<td>arrayref, index, value →</td>
<td>stores a double into an array
</td></tr>
<tr>
<td>dcmpg</td>
<td align="center">98</td>
<td></td>
<td>value1, value2 → result</td>
<td>compares two doubles
</td></tr>
<tr>
<td>dcmpl</td>
<td align="center">97</td>
<td></td>
<td>value1, value2 → result</td>
<td>compares two doubles
</td></tr>
<tr>
<td>dconst_0</td>
<td align="center">0e</td>
<td></td>
<td>→ 0.0</td>
<td>pushes the constant <i>0.0</i> onto the stack
</td></tr>
<tr>
<td>dconst_1</td>
<td align="center">0f</td>
<td></td>
<td>→ 1.0</td>
<td>pushes the constant <i>1.0</i> onto the stack
</td></tr>
<tr>
<td>ddiv</td>
<td align="center">6f</td>
<td></td>
<td>value1, value2 → result</td>
<td>divides two doubles
</td></tr>
<tr>
<td>dload</td>
<td align="center">18</td>
<td>index</td>
<td>→ value</td>
<td>loads a double <i>value</i> from a local variable <i>#index</i>
</td></tr>
<tr>
<td>dload_0</td>
<td align="center">26</td>
<td></td>
<td>→ value</td>
<td>loads a double from local variable 0
</td></tr>
<tr>
<td>dload_1</td>
<td align="center">27</td>
<td></td>
<td>→ value</td>
<td>loads a double from local variable 1
</td></tr>
<tr>
<td>dload_2</td>
<td align="center">28</td>
<td></td>
<td>→ value</td>
<td>loads a double from local variable 2
</td></tr>
<tr>
<td>dload_3</td>
<td align="center">29</td>
<td></td>
<td>→ value</td>
<td>loads a double from local variable 3
</td></tr>
<tr>
<td>dmul</td>
<td align="center">6b</td>
<td></td>
<td>value1, value2 → result</td>
<td>multiplies two doubles
</td></tr>
<tr>
<td>dneg</td>
<td align="center">77</td>
<td></td>
<td>value → result</td>
<td>negates a double
</td></tr>
<tr>
<td>drem</td>
<td align="center">73</td>
<td></td>
<td>value1, value2 → result</td>
<td>gets the remainder from a division between two doubles
</td></tr>
<tr>
<td>dreturn</td>
<td align="center">af</td>
<td></td>
<td>value → [empty]</td>
<td>returns a double from a method
</td></tr>
<tr>
<td>dstore</td>
<td align="center">39</td>
<td>index</td>
<td>value →</td>
<td>stores a double <i>value</i> into a local variable <i>#index</i>
</td></tr>
<tr>
<td>dstore_0</td>
<td align="center">47</td>
<td></td>
<td>value →</td>
<td>stores a double into local variable 0
</td></tr>
<tr>
<td>dstore_1</td>
<td align="center">48</td>
<td></td>
<td>value →</td>
<td>stores a double into local variable 1
</td></tr>
<tr>
<td>dstore_2</td>
<td align="center">49</td>
<td></td>
<td>value →</td>
<td>stores a double into local variable 2
</td></tr>
<tr>
<td>dstore_3</td>
<td align="center">4a</td>
<td></td>
<td>value →</td>
<td>stores a double into local variable 3
</td></tr>
<tr>
<td>dsub</td>
<td align="center">67</td>
<td></td>
<td>value1, value2 → result</td>
<td>subtracts a double from another
</td></tr>
<tr>
<td>dup</td>
<td align="center">59</td>
<td></td>
<td>value → value, value</td>
<td>duplicates the value on top of the stack
</td></tr>
<tr>
<td>dup_x1</td>
<td align="center">5a</td>
<td></td>
<td>value2, value1 → value1, value2, value1</td>
<td>inserts a copy of the top value into the stack two values from the top
</td></tr>
<tr>
<td>dup_x2</td>
<td align="center">5b</td>
<td></td>
<td>value3, value2, value1 → value1, value3, value2, value1</td>
<td>inserts a copy of the top value into the stack two (if value2 is double or long it takes up the entry of value3, too) or three values (if value2 is neither double nor long) from the top
</td></tr>
<tr>
<td>dup2</td>
<td align="center">5c</td>
<td></td>
<td>{value2, value1} → {value2, value1}, {value2, value1}</td>
<td>duplicate top two stack words (two values, if value1 is not double nor long; a single value, if value1 is double or long)
</td></tr>
<tr>
<td>dup2_x1</td>
<td align="center">5d</td>
<td></td>
<td>value3, {value2, value1} → {value2, value1}, value3, {value2, value1}</td>
<td>duplicate two words and insert beneath third word (see explanation above)
</td></tr>
<tr>
<td>dup2_x2</td>
<td align="center">5e</td>
<td></td>
<td>{value4, value3}, {value2, value1} → {value2, value1}, {value4, value3}, {value2, value1}</td>
<td>duplicate two words and insert beneath fourth word
</td></tr>
<tr>
<th colspan="5">F
</th></tr>
<tr>
<td>f2d</td>
<td align="center">8d</td>
<td></td>
<td>value → result</td>
<td>converts a float to a double
</td></tr>
<tr>
<td>f2i</td>
<td align="center">8b</td>
<td></td>
<td>value → result</td>
<td>converts a float to an int
</td></tr>
<tr>
<td>f2l</td>
<td align="center">8c</td>
<td></td>
<td>value → result</td>
<td>converts a float to a long
</td></tr>
<tr>
<td>fadd</td>
<td align="center">62</td>
<td></td>
<td>value1, value2 → result</td>
<td>adds two floats
</td></tr>
<tr>
<td>faload</td>
<td align="center">30</td>
<td></td>
<td>arrayref, index → value</td>
<td>loads a float from an array
</td></tr>
<tr>
<td>fastore</td>
<td align="center">51</td>
<td></td>
<td>arreyref, index, value →</td>
<td>stores a float in an array
</td></tr>
<tr>
<td>fcmpg</td>
<td align="center">96</td>
<td></td>
<td>value1, value2 → result</td>
<td>compares two floats
</td></tr>
<tr>
<td>fcmpl</td>
<td align="center">95</td>
<td></td>
<td>value1, value2 → result</td>
<td>compares two floats
</td></tr>
<tr>
<td>fconst_0</td>
<td align="center">0b</td>
<td></td>
<td>→ 0.0f</td>
<td>pushes <i>0.0f</i> on the stack
</td></tr>
<tr>
<td>fconst_1</td>
<td align="center">0c</td>
<td></td>
<td>→ 1.0f</td>
<td>pushes <i>1.0f</i> on the stack
</td></tr>
<tr>
<td>fconst_2</td>
<td align="center">0d</td>
<td></td>
<td>→ 2.0f</td>
<td>pushes <i>2.0f</i> on the stack
</td></tr>
<tr>
<td>fdiv</td>
<td align="center">6e</td>
<td></td>
<td>value1, value2 → result</td>
<td>divides two floats
</td></tr>
<tr>
<td>fload</td>
<td align="center">17</td>
<td>index</td>
<td>→ value</td>
<td>loads a float <i>value</i> from a local variable <i>#index</i>
</td></tr>
<tr>
<td>fload_0</td>
<td align="center">22</td>
<td></td>
<td>→ value</td>
<td>loads a float <i>value</i> from local variable 0
</td></tr>
<tr>
<td>fload_1</td>
<td align="center">23</td>
<td></td>
<td>→ value</td>
<td>loads a float <i>value</i> from local variable 1
</td></tr>
<tr>
<td>fload_2</td>
<td align="center">24</td>
<td></td>
<td>→ value</td>
<td>loads a float <i>value</i> from local variable 2
</td></tr>
<tr>
<td>fload_3</td>
<td align="center">25</td>
<td></td>
<td>→ value</td>
<td>loads a float <i>value</i> from local variable 3
</td></tr>
<tr>
<td>fmul</td>
<td align="center">6a</td>
<td></td>
<td>value1, value2 → result</td>
<td>multiplies two floats
</td></tr>
<tr>
<td>fneg</td>
<td align="center">76</td>
<td></td>
<td>value → result</td>
<td>negates a float
</td></tr>
<tr>
<td>frem</td>
<td align="center">72</td>
<td></td>
<td>value1, value2 → result</td>
<td>gets the remainder from a division between two floats
</td></tr>
<tr>
<td>freturn</td>
<td align="center">ae</td>
<td></td>
<td>value → [empty]</td>
<td>returns a float from method
</td></tr>
<tr>
<td>fstore</td>
<td align="center">38</td>
<td>index</td>
<td>value →</td>
<td>stores a float <i>value</i> into a local variable <i>#index</i>
</td></tr>
<tr>
<td>fstore_0</td>
<td align="center">43</td>
<td></td>
<td>value →</td>
<td>stores a float <i>value</i> into local variable 0
</td></tr>
<tr>
<td>fstore_1</td>
<td align="center">44</td>
<td></td>
<td>value →</td>
<td>stores a float <i>value</i> into local variable 1
</td></tr>
<tr>
<td>fstore_2</td>
<td align="center">45</td>
<td></td>
<td>value →</td>
<td>stores a float <i>value</i> into local variable 2
</td></tr>
<tr>
<td>fstore_3</td>
<td align="center">46</td>
<td></td>
<td>value →</td>
<td>stores a float <i>value</i> into local variable 3
</td></tr>
<tr>
<td>fsub</td>
<td align="center">66</td>
<td></td>
<td>value1, value2 → result</td>
<td>subtracts two floats
</td></tr>
<tr>
<th colspan="5">G
</th></tr>
<tr>
<td>getfield</td>
<td align="center">b4</td>
<td>index1, index2</td>
<td>objectref → value</td>
<td>gets a field <i>value</i> of an object <i>objectref</i>, where the field is identified by field reference in the constant pool <i>index</i> (<i>index1 &lt;&lt; 8 + index2</i>)
</td></tr>
<tr>
<td>getstatic</td>
<td align="center">b2</td>
<td>index1, index2</td>
<td>→ value</td>
<td>gets a static field <i>value</i> of a class, where the field is identified by field reference in the constant pool <i>index</i> (<i>index1 &lt;&lt; 8 + index2</i>)
</td></tr>
<tr>
<td>goto</td>
<td align="center">a7</td>
<td>branchbyte1, branchbyte2</td>
<td>[no change]</td>
<td>goes to another instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>goto_w</td>
<td align="center">c8</td>
<td>branchbyte1, branchbyte2, branchbyte3, branchbyte4</td>
<td>[no change]</td>
<td>goes to another instruction at <i>branchoffset</i> (signed int constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 24 + </i>branchbyte2 &lt;&lt; 16 + <i>branchbyte3 &lt;&lt; 8 + branchbyte4</i>)
</td></tr>
<tr>
<th colspan="5">I
</th></tr>
<tr>
<td>i2b</td>
<td align="center">91</td>
<td></td>
<td>value → result</td>
<td>converts an int into a byte
</td></tr>
<tr>
<td>i2c</td>
<td align="center">92</td>
<td></td>
<td>value → result</td>
<td>converts an int into a character
</td></tr>
<tr>
<td>i2d</td>
<td align="center">87</td>
<td></td>
<td>value → result</td>
<td>converts an int into a double
</td></tr>
<tr>
<td>i2f</td>
<td align="center">86</td>
<td></td>
<td>value → result</td>
<td>converts an int into a float
</td></tr>
<tr>
<td>i2l</td>
<td align="center">85</td>
<td></td>
<td>value → result</td>
<td>converts an int into a long
</td></tr>
<tr>
<td>i2s</td>
<td align="center">93</td>
<td></td>
<td>value → result</td>
<td>converts an int into a short
</td></tr>
<tr>
<td>iadd</td>
<td align="center">60</td>
<td></td>
<td>value1, value2 → result</td>
<td>adds two ints together
</td></tr>
<tr>
<td>iaload</td>
<td align="center">2e</td>
<td></td>
<td>arrayref, index → value</td>
<td>loads an int from an array
</td></tr>
<tr>
<td>iand</td>
<td align="center">7e</td>
<td></td>
<td>value1, value2 → result</td>
<td>performs a logical and on two integers
</td></tr>
<tr>
<td>iastore</td>
<td align="center">4f</td>
<td></td>
<td>arrayref, index, value →</td>
<td>stores an int into an array
</td></tr>
<tr>
<td>iconst_m1</td>
<td align="center">02</td>
<td></td>
<td>→ -1</td>
<td>loads the int value -1 onto the stack
</td></tr>
<tr>
<td>iconst_0</td>
<td align="center">03</td>
<td></td>
<td>→ 0</td>
<td>loads the int value 0 onto the stack
</td></tr>
<tr>
<td>iconst_1</td>
<td align="center">04</td>
<td></td>
<td>→ 1</td>
<td>loads the int value 1 onto the stack
</td></tr>
<tr>
<td>iconst_2</td>
<td align="center">05</td>
<td></td>
<td>→ 2</td>
<td>loads the int value 2 onto the stack
</td></tr>
<tr>
<td>iconst_3</td>
<td align="center">06</td>
<td></td>
<td>→ 3</td>
<td>loads the int value 3 onto the stack
</td></tr>
<tr>
<td>iconst_4</td>
<td align="center">07</td>
<td></td>
<td>→ 4</td>
<td>loads the int value 4 onto the stack
</td></tr>
<tr>
<td>iconst_5</td>
<td align="center">08</td>
<td></td>
<td>→ 5</td>
<td>loads the int value 5 onto the stack
</td></tr>
<tr>
<td>idiv</td>
<td align="center">6c</td>
<td></td>
<td>value1, value2 → result</td>
<td>divides two integers
</td></tr>
<tr>
<td>if_acmpeq</td>
<td align="center">a5</td>
<td>branchbyte1, branchbyte2</td>
<td>value1, value2 →</td>
<td>if references are equal, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>if_acmpne</td>
<td align="center">a6</td>
<td>branchbyte1, branchbyte2</td>
<td>value1, value2 →</td>
<td>if references are not equal, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>if_icmpeq</td>
<td align="center">9f</td>
<td>branchbyte1, branchbyte2</td>
<td>value1, value2 →</td>
<td>if ints are equal, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>if_icmpne</td>
<td align="center">a0</td>
<td>branchbyte1, branchbyte2</td>
<td>value1, value2 →</td>
<td>if ints are not equal, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>if_icmplt</td>
<td align="center">a1</td>
<td>branchbyte1, branchbyte2</td>
<td>value1, value2 →</td>
<td>if <i>value1</i> is less than <i>value2</i>, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>if_icmpge</td>
<td align="center">a2</td>
<td>branchbyte1, branchbyte2</td>
<td>value1, value2 →</td>
<td>if <i>value1</i> is greater than or equal to <i>value2</i>, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>if_icmpgt</td>
<td align="center">a3</td>
<td>branchbyte1, branchbyte2</td>
<td>value1, value2 →</td>
<td>if <i>value1</i> is greater than <i>value2</i>, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>if_icmple</td>
<td align="center">a4</td>
<td>branchbyte1, branchbyte2</td>
<td>value1, value2 →</td>
<td>if <i>value1</i> is less than or equal to <i>value2</i>, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>ifeq</td>
<td align="center">99</td>
<td>branchbyte1, branchbyte2</td>
<td>value →</td>
<td>if <i>value</i> is 0, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>ifne</td>
<td align="center">9a</td>
<td>branchbyte1, branchbyte2</td>
<td>value →</td>
<td>if <i>value</i> is not 0, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>iflt</td>
<td align="center">9b</td>
<td>branchbyte1, branchbyte2</td>
<td>value →</td>
<td>if <i>value</i> is less than 0, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>ifge</td>
<td align="center">9c</td>
<td>branchbyte1, branchbyte2</td>
<td>value →</td>
<td>if <i>value</i> is greater than or equal to 0, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>ifgt</td>
<td align="center">9d</td>
<td>branchbyte1, branchbyte2</td>
<td>value →</td>
<td>if <i>value</i> is greater than 0, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>ifle</td>
<td align="center">9e</td>
<td>branchbyte1, branchbyte2</td>
<td>value →</td>
<td>if <i>value</i> is less than or equal to 0, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>ifnonnull</td>
<td align="center">c7</td>
<td>branchbyte1, branchbyte2</td>
<td>value →</td>
<td>if <i>value</i> is not null, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>ifnull</td>
<td align="center">c6</td>
<td>branchbyte1, branchbyte2</td>
<td>value →</td>
<td>if <i>value</i> is null, branch to instruction at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>)
</td></tr>
<tr>
<td>iinc</td>
<td align="center">84</td>
<td>index, const</td>
<td>[No change]</td>
<td>increment local variable <i>#index</i> by signed byte <i>const</i>
</td></tr>
<tr>
<td>iload</td>
<td align="center">15</td>
<td>index</td>
<td>→ value</td>
<td>loads an int <i>value</i> from a variable <i>#index</i>
</td></tr>
<tr>
<td>iload_0</td>
<td align="center">1a</td>
<td></td>
<td>→ value</td>
<td>loads an int <i>value</i> from variable 0
</td></tr>
<tr>
<td>iload_1</td>
<td align="center">1b</td>
<td></td>
<td>→ value</td>
<td>loads an int <i>value</i> from variable 1
</td></tr>
<tr>
<td>iload_2</td>
<td align="center">1c</td>
<td></td>
<td>→ value</td>
<td>loads an int <i>value</i> from variable 2
</td></tr>
<tr>
<td>iload_3</td>
<td align="center">1d</td>
<td></td>
<td>→ value</td>
<td>loads an int <i>value</i> from variable 3
</td></tr>
<tr>
<td>imul</td>
<td align="center">68</td>
<td></td>
<td>value1, value2 → result</td>
<td>multiply two integers
</td></tr>
<tr>
<td>ineg</td>
<td align="center">74</td>
<td></td>
<td>value → result</td>
<td>negate int
</td></tr>
<tr>
<td>instanceof</td>
<td align="center">c1</td>
<td>indexbyte1, indexbyte2</td>
<td>objectref → result</td>
<td>determines if an object <i>objectref</i> is of a given type, identified by class reference <i>index</i> in constant pool (<i>indexbyte1 &lt;&lt; 8 + indexbyte2</i>)
</td></tr>
<tr>
<td>invokeinterface</td>
<td align="center">b9</td>
<td>indexbyte1, indexbyte2, count, 0</td>
<td>objectref, [arg1, arg2, ...] →</td>
<td>invokes an interface method on object <i>objectref</i>, where the interface method is identified by method reference <i>index</i> in constant pool (<i>indexbyte1 &lt;&lt; 8 + indexbyte2</i>) and <i>count</i> is the number of arguments to pop from the stack frame including the object on which the method is being called and must always be greater than or equal to 1
</td></tr>
<tr>
<td>invokespecial</td>
<td align="center">b7</td>
<td>indexbyte1, indexbyte2</td>
<td>objectref, [arg1, arg2, ...] →</td>
<td>invoke instance method on object <i>objectref</i> requiring special handling (instance initialization method, a private method, or a superclass method), where the method is identified by method reference <i>index</i> in constant pool (<i>indexbyte1 &lt;&lt; 8 + indexbyte2</i>)
</td></tr>
<tr>
<td>invokestatic</td>
<td align="center">b8</td>
<td>indexbyte1, indexbyte2</td>
<td>[arg1, arg2, ...] →</td>
<td>invoke a static method, where the method is identified by method reference <i>index</i> in constant pool (<i>indexbyte1 &lt;&lt; 8 + indexbyte2</i>)
</td></tr>
<tr>
<td>invokevirtual</td>
<td align="center">b6</td>
<td>indexbyte1, indexbyte2</td>
<td>objectref, [arg1, arg2, ...] →</td>
<td>invoke virtual method on object <i>objectref</i>, where the method is identified by method reference <i>index</i> in constant pool (<i>indexbyte1 &lt;&lt; 8 + indexbyte2</i>)
</td></tr>
<tr>
<td>ior</td>
<td align="center">80</td>
<td></td>
<td>value1, value2 → result</td>
<td>logical int or
</td></tr>
<tr>
<td>irem</td>
<td align="center">70</td>
<td></td>
<td>value1, value2 → result</td>
<td>logical int remainder
</td></tr>
<tr>
<td>ireturn</td>
<td align="center">ac</td>
<td></td>
<td>value → [empty]</td>
<td>returns an integer from a method
</td></tr>
<tr>
<td>ishl</td>
<td align="center">78</td>
<td></td>
<td>value1, value2 → result</td>
<td>int shift left
</td></tr>
<tr>
<td>ishr</td>
<td align="center">7a</td>
<td></td>
<td>value1, value2 → result</td>
<td>int shift right
</td></tr>
<tr>
<td>istore</td>
<td align="center">36</td>
<td>index</td>
<td>value →</td>
<td>store int <i>value</i> into variable <i>#index</i>
</td></tr>
<tr>
<td>istore_0</td>
<td align="center">3b</td>
<td></td>
<td>value →</td>
<td>store int <i>value</i> into variable 0
</td></tr>
<tr>
<td>istore_1</td>
<td align="center">3c</td>
<td></td>
<td>value →</td>
<td>store int <i>value</i> into variable 1
</td></tr>
<tr>
<td>istore_2</td>
<td align="center">3d</td>
<td></td>
<td>value →</td>
<td>store int <i>value</i> into variable 2
</td></tr>
<tr>
<td>istore_3</td>
<td align="center">3e</td>
<td></td>
<td>value →</td>
<td>store int <i>value</i> into variable 3
</td></tr>
<tr>
<td>isub</td>
<td align="center">64</td>
<td></td>
<td>value1, value2 → result</td>
<td>int subtract
</td></tr>
<tr>
<td>iushr</td>
<td align="center">7c</td>
<td></td>
<td>value1, value2 → result</td>
<td>int shift right
</td></tr>
<tr>
<td>ixor</td>
<td align="center">82</td>
<td></td>
<td>value1, value2 → result</td>
<td>int xor
</td></tr>
<tr>
<th colspan="5">J
</th></tr>
<tr>
<td>jsr</td>
<td align="center">a8</td>
<td>branchbyte1, branchbyte2</td>
<td>→ address</td>
<td>jump to subroutine at <i>branchoffset</i> (signed short constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 8 + branchbyte2</i>) and place the return address on the stack
</td></tr>
<tr>
<td>jsr_w</td>
<td align="center">c9</td>
<td>branchbyte1, branchbyte2, branchbyte3, branchbyte4</td>
<td>→ address</td>
<td>jump to subroutine at <i>branchoffset</i> (signed int constructed from unsigned bytes <i>branchbyte1 &lt;&lt; 24 + branchbyte2 &lt;&lt; 16 + branchbyte3 &lt;&lt; 8 + branchbyte4</i>) and place the return address on the stack
</td></tr>
<tr>
<th colspan="5">L
</th></tr>
<tr>
<td>l2d</td>
<td align="center">8a</td>
<td></td>
<td>value → result</td>
<td>converts a long to a double
</td></tr>
<tr>
<td>l2f</td>
<td align="center">89</td>
<td></td>
<td>value → result</td>
<td>converts a long to a float
</td></tr>
<tr>
<td>l2i</td>
<td align="center">88</td>
<td></td>
<td>value → result</td>
<td>converts a long to an int
</td></tr>
<tr>
<td>ladd</td>
<td align="center">61</td>
<td></td>
<td>value1, value2 → result</td>
<td>add two longs
</td></tr>
<tr>
<td>laload</td>
<td align="center">2f</td>
<td></td>
<td>arrayref, index → value</td>
<td>load a long from an array
</td></tr>
<tr>
<td>land</td>
<td align="center">7f</td>
<td></td>
<td>value1, value2 → result</td>
<td>bitwise and of two longs
</td></tr>
<tr>
<td>lastore</td>
<td align="center">50</td>
<td></td>
<td>arrayref, index, value →</td>
<td>store a long to an array
</td></tr>
<tr>
<td>lcmp</td>
<td align="center">94</td>
<td></td>
<td>value1, value2 → result</td>
<td>compares two longs values
</td></tr>
<tr>
<td>lconst_0</td>
<td align="center">09</td>
<td></td>
<td>→ 0L</td>
<td>pushes the long 0 onto the stack
</td></tr>
<tr>
<td>lconst_1</td>
<td align="center">0a</td>
<td></td>
<td>→ 1L</td>
<td>pushes the long 1 onto the stack
</td></tr>
<tr>
<td>ldc</td>
<td align="center">12</td>
<td>index</td>
<td>→ value</td>
<td>pushes a constant <i>#index</i> from a constant pool (String, int, float or class type) onto the stack
</td></tr>
<tr>
<td>ldc_w</td>
<td align="center">13</td>
<td>indexbyte1, indexbyte2</td>
<td>→ value</td>
<td>pushes a constant <i>#index</i> from a constant pool (String, int, float or class type) onto the stack (wide <i>index</i> is constructed as <i>indexbyte1 &lt;&lt; 8 + indexbyte2</i>)
</td></tr>
<tr>
<td>ldc2_w</td>
<td align="center">14</td>
<td>indexbyte1, indexbyte2</td>
<td>→ value</td>
<td>pushes a constant <i>#index</i> from a constant pool (double or long) onto the stack (wide <i>index</i> is constructed as <i>indexbyte1 &lt;&lt; 8 + indexbyte2</i>)
</td></tr>
<tr>
<td>ldiv</td>
<td align="center">6d</td>
<td></td>
<td>value1, value2 → result</td>
<td>divide two longs
</td></tr>
<tr>
<td>lload</td>
<td align="center">16</td>
<td>index</td>
<td>→ value</td>
<td>load a long value from a local variable <i>#index</i>
</td></tr>
<tr>
<td>lload_0</td>
<td align="center">1e</td>
<td></td>
<td>→ value</td>
<td>load a long value from a local variable 0
</td></tr>
<tr>
<td>lload_1</td>
<td align="center">1f</td>
<td></td>
<td>→ value</td>
<td>load a long value from a local variable 1
</td></tr>
<tr>
<td>lload_2</td>
<td align="center">20</td>
<td></td>
<td>→ value</td>
<td>load a long value from a local variable 2
</td></tr>
<tr>
<td>lload_3</td>
<td align="center">21</td>
<td></td>
<td>→ value</td>
<td>load a long value from a local variable 3
</td></tr>
<tr>
<td>lmul</td>
<td align="center">69</td>
<td></td>
<td>value1, value2 → result</td>
<td>multiplies two longs
</td></tr>
<tr>
<td>lneg</td>
<td align="center">75</td>
<td></td>
<td>value → result</td>
<td>negates a long
</td></tr>
<tr>
<td>lookupswitch</td>
<td align="center">ab</td>
<td>&lt;0-3 bytes padding&gt;, defaultbyte1, defaultbyte2, defaultbyte3, defaultbyte4, npairs1, npairs2, npairs3, npairs4, match-offset pairs...</td>
<td>key →</td>
<td>a target address is looked up from a table using a key and execution continues from the instruction at that address
</td></tr>
<tr>
<td>lor</td>
<td align="center">81</td>
<td></td>
<td>value1, value2 → result</td>
<td>bitwise or of two longs
</td></tr>
<tr>
<td>lrem</td>
<td align="center">71</td>
<td></td>
<td>value1, value2 → result</td>
<td>remainder of division of two longs
</td></tr>
<tr>
<td>lreturn</td>
<td align="center">ad</td>
<td></td>
<td>value → [empty]</td>
<td>returns a long value
</td></tr>
<tr>
<td>lshl</td>
<td align="center">79</td>
<td></td>
<td>value1, value2 → result</td>
<td>bitwise shift left of a long <i>value1</i> by <i>value2</i> positions
</td></tr>
<tr>
<td>lshr</td>
<td align="center">7b</td>
<td></td>
<td>value1, value2 → result</td>
<td>bitwise shift right of a long <i>value1</i> by <i>value2</i> positions
</td></tr>
<tr>
<td>lstore</td>
<td align="center">37</td>
<td>index</td>
<td>value →</td>
<td>store a long <i>value</i> in a local variable <i>#index</i>
</td></tr>
<tr>
<td>lstore_0</td>
<td align="center">3f</td>
<td></td>
<td>value →</td>
<td>store a long <i>value</i> in a local variable 0
</td></tr>
<tr>
<td>lstore_1</td>
<td align="center">40</td>
<td></td>
<td>value →</td>
<td>store a long <i>value</i> in a local variable 1
</td></tr>
<tr>
<td>lstore_2</td>
<td align="center">41</td>
<td></td>
<td>value →</td>
<td>store a long <i>value</i> in a local variable 2
</td></tr>
<tr>
<td>lstore_3</td>
<td align="center">42</td>
<td></td>
<td>value →</td>
<td>store a long <i>value</i> in a local variable 3
</td></tr>
<tr>
<td>lsub</td>
<td align="center">65</td>
<td></td>
<td>value1, value2 → result</td>
<td>subtract two longs
</td></tr>
<tr>
<td>lushr</td>
<td align="center">7d</td>
<td></td>
<td>value1, value2 → result</td>
<td>bitwise shift right of a long <i>value1</i> by <i>value2</i> positions, unsigned
</td></tr>
<tr>
<td>lxor</td>
<td align="center">83</td>
<td></td>
<td>value1, value2 → result</td>
<td>bitwise exclusive or of two longs
</td></tr>
<tr>
<th colspan="5">M
</th></tr>
<tr>
<td>monitorenter</td>
<td align="center">c2</td>
<td></td>
<td>objectref →</td>
<td>enter monitor for object ("grab the lock" - start of synchronized() section)
</td></tr>
<tr>
<td>monitorexit</td>
<td align="center">c3</td>
<td></td>
<td>objectref →</td>
<td>exit monitor for object ("release the lock" - end of synchronized() section)
</td></tr>
<tr>
<td>multianewarray</td>
<td align="center">c5</td>
<td>indexbyte1, indexbyte2, dimensions</td>
<td>count1, [count2,...] → arrayref</td>
<td>create a new array of <i>dimensions</i> dimensions with elements of type identified by class reference in constant pool <i>index</i> (<i>indexbyte1 &lt;&lt; 8 + indexbyte2</i>); the sizes of each dimension is identified by <i>count1</i>, [<i>count2</i>, etc]
</td></tr>
<tr>
<th colspan="5">N
</th></tr>
<tr>
<td>new</td>
<td align="center">bb</td>
<td>indexbyte1, indexbyte2</td>
<td>→ objectref</td>
<td>creates new object of type identified by class reference in constant pool <i>index</i> (<i>indexbyte1 &lt;&lt; 8 + indexbyte2</i>)
</td></tr>
<tr>
<td>newarray</td>
<td align="center">bc</td>
<td>atype</td>
<td>count → arrayref</td>
<td>creates new array with <i>count</i> elements of primitive type identified by <i>atype</i>
</td></tr>
<tr>
<td><a href="/w/index.php?title=Nop&amp;action=edit&amp;redlink=1" class="new" title="Nop (does not exist)">nop</a></td>
<td align="center">00</td>
<td></td>
<td>[No change]</td>
<td>performs no operation
</td></tr>
<tr>
<th colspan="5">P
</th></tr>
<tr>
<td>pop</td>
<td align="center">57</td>
<td></td>
<td>value →</td>
<td>discards the top value on the stack
</td></tr>
<tr>
<td>pop2</td>
<td align="center">58</td>
<td></td>
<td>{value2, value1} →</td>
<td>discards the top two values on the stack (or one value, if it is a double or long)
</td></tr>
<tr>
<td>putfield</td>
<td align="center">b5</td>
<td>indexbyte1, indexbyte2</td>
<td>objectref, value →</td>
<td>set field to <i>value</i> in an object <i>objectref</i>, where the field is identified by a field reference <i>index</i> in constant pool (<i>indexbyte1 &lt;&lt; 8 + indexbyte2</i>)
</td></tr>
<tr>
<td>putstatic</td>
<td align="center">b3</td>
<td>indexbyte1, indexbyte2</td>
<td>value →</td>
<td>set static field to <i>value</i> in a class, where the field is identified by a field reference <i>index</i> in constant pool (<i>indexbyte1 &lt;&lt; 8 + indexbyte2</i>)
</td></tr>
<tr>
<th colspan="5">R
</th></tr>
<tr>
<td>ret</td>
<td align="center">a9</td>
<td>index</td>
<td>[No change]</td>
<td>continue execution from address taken from a local variable <i>#index</i> (the asymmetry with jsr is intentional)
</td></tr>
<tr>
<td>return</td>
<td align="center">b1</td>
<td></td>
<td>→ [empty]</td>
<td>return void from method
</td></tr>
<tr>
<th colspan="5">S
</th></tr>
<tr>
<td>saload</td>
<td align="center">35</td>
<td></td>
<td>arrayref, index → value</td>
<td>load short from array
</td></tr>
<tr>
<td>sastore</td>
<td align="center">56</td>
<td></td>
<td>arrayref, index, value →</td>
<td>store short to array
</td></tr>
<tr>
<td>sipush</td>
<td align="center">11</td>
<td>byte1, byte2</td>
<td>→ value</td>
<td>pushes a signed integer (<i>byte1 &lt;&lt; 8 + byte2</i>) onto the stack
</td></tr>
<tr>
<td>swap</td>
<td align="center">5f</td>
<td></td>
<td>value2, value1 → value1, value2</td>
<td>swaps two top words on the stack (note that value1 and value2 must not be double or long)
</td></tr>
<tr>
<th colspan="5">T
</th></tr>
<tr>
<td>tableswitch</td>
<td align="center">aa</td>
<td>[0-3 bytes padding], defaultbyte1, defaultbyte2, defaultbyte3, defaultbyte4, lowbyte1, lowbyte2, lowbyte3, lowbyte4, highbyte1, highbyte2, highbyte3, highbyte4, jump offsets...</td>
<td>index →</td>
<td>continue execution from an address in the table at offset <i>index</i>
</td></tr>
<tr>
<th colspan="5">W
</th></tr>
<tr>
<td>wide</td>
<td align="center">c4</td>
<td>opcode, indexbyte1, indexbyte2 <br />or<br /> iinc, indexbyte1, indexbyte2, countbyte1, countbyte2</td>
<td>[same as for corresponding instructions]</td>
<td>execute <i>opcode</i>, where <i>opcode</i> is either iload, fload, aload, lload, dload, istore, fstore, astore, lstore, dstore, or ret, but assume the <i>index</i> is 16 bit; or execute iinc, where the <i>index</i> is 16 bits and the constant to increment by is a signed 16 bit short
</td></tr>
<tr>
<th colspan="5">Unused
</th></tr>
<tr>
<td>breakpoint</td>
<td align="center">ca</td>
<td></td>
<td></td>
<td>reserved for breakpoints in Java debuggers; should not appear in any class file
</td></tr>
<tr>
<td>impdep1</td>
<td align="center">fe</td>
<td></td>
<td></td>
<td>reserved for implementation-dependent operations within debuggers; should not appear in any class file
</td></tr>
<tr>
<td>impdep2</td>
<td align="center">ff</td>
<td></td>
<td></td>
<td>reserved for implementation-dependent operations within debuggers; should not appear in any class file
</td></tr>
<tr>
<td><i>(no name)</i></td>
<td align="center">cb-fd</td>
<td></td>
<td></td>
<td>these values are currently unassigned for opcodes and are reserved for future use
</td></tr>
<tr>
<td>xxxunusedxxx</td>
<td align="center">ba</td>
<td></td>
<td></td>
<td>this opcode is reserved "for historical reasons"
</td></tr></tbody></table>
