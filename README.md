# Jortune
Java reimplementation of the classic fortune command

I made this one night, just to try to get back into Java, as it was the only language I knew well.

It's very simple, and not all that efficient, though with moderately sized fortune files
(I tested with 19-82KB files) it uses around 2MB of RAM. No big deal these days.

To run it, just run 
`javac Jortune.java`
and then
`java Jortune <file>`
where file is a % delimited plaintext file of quotes.
