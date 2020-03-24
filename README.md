# Versus Systems Coding Challenge

Hello! Thank you for taking the time to complete the Versus Systems coding challenge. Feel free to reach out if anything below is unclear, otherwise we look forward to reviewing your submission!

## General Stuff

**Time:** Please don't spend more than an hour or so on this. If you find yourself starting to take longer than that, feel free to stop coding and jot down your next steps in note form &mdash; they can serve as a discussion point during the in-person phase of your interview.

**Language:** We're an Elixir shop, but feel free to use any server-side language you feel comfortable with (Ruby, Java, Python, Node, etc). We care more about seeing clean, well-structured code than we do about seeing any particular language.

**Deliverables:** When you're done, please send us either a ZIP file or a link to a Github repo with your code. Either way, make sure to include a README explaining how to run it.


## The Problem

All data that flows in or out of our API gets saved to a log. This is helpful when debugging, but unfortunately means that all of our users' personal information gets stored in plain text. In order to respect our users' privacy, we need to clean this up.

## Your Task

To handle this, you must write a `scrub` to remove all personal information from a piece of data before it is logged. This function will take in an object and perform the following transformations:
* replace all "name", "username", and "password" values with the string "********"
* for all "email" fields, replace only the username (the part before the @)

Assume that personal data can be nested inside objects or arrays at any depth. The final result should do this:

<table>
  <tr>
    <th>
      Example In
    </th>
    <th>
      Example Out
    </th>
  </tr>
  <tr>
    <td>
      <pre>
{
  "id": 123,
  "name": "Elsa",
  "username": "xXfrozen_princessXx",
  "email": "elsa@arendelle.com",
  "age": 21,
  "power": "ice ray",
  "friends": [{
    "id": 234,
    "username": "MagicSnowman32"
  }, {
    "id": 456,
    "username": "call_me_anna"
  }]
}
</pre>
</td>
<td>
<pre>
{
  "id": 123,
  "name": "******",
  "username": "******",
  "email": "******@arendelle.com",
  "age": 21,
  "power": "ice ray",
  "friends": [{
    "id": 234,
    "username": "******"
  }, {
    "id": 456,
    "username": "******"
  }]
}
</pre>
</td>
</tr>
</table>

## That's it!
Good luck, and happy coding!
