import React from 'react';
let { Client } = require('pg');

let client = new Client({
  user: 'student',
  host: 'jdbc:postgresql',
  database: 'sample',
  password: 'himitu',
  port: 5432
})

client.connect()

const query = {
  text: 'select * from webbook'
};

client.query(query, (err, res) => {
  if (err) {

      console.log(err.stack)

  } else {

      console.log(res.rows[0])

  }
})

client.query(query)
  .then(res => console.log(res.rows[0]))
  .catch(e => console.error(e.stack))