import React, { useState } from 'react';
import axios from 'axios';

const EmailForm = () => {
  const [to, setTo] = useState('');
  const [subject, setSubject] = useState('');
  const [body, setBody] = useState('');

  const handleSendEmail = async () => {
    try {
      const backendURL = 'http://localhost:3000'; // Assurez-vous que le port est correct
  
      // Utilisez les paramètres de la requête plutôt que le corps
      await axios.post(`${backendURL}/email/send`, null, {
        params: {
          to,
          subject,
          body,
        },
      });
  
      console.log('Email sent successfully');
    } catch (error) {
      console.error('Error sending email:', error);
    }
  };

  return (
    <div>
      <h1>Email Form</h1>
      <label>To:</label>
      <input type="text" value={to} onChange={(e) => setTo(e.target.value)} />
      <br />
      <label>Subject:</label>
      <input type="text" value={subject} onChange={(e) => setSubject(e.target.value)} />
      <br />
      <label>Body:</label>
      <textarea value={body} onChange={(e) => setBody(e.target.value)} />
      <br />
      <button onClick={handleSendEmail}>Send Email</button>
    </div>
  );
};

export default EmailForm;
