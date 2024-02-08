// EmployeeForm.js

import React, { useState, useEffect } from 'react';

const EmployeeForm = ({ onSubmit, employee }) => {
  const [employeeData, setEmployeeData] = useState({
    departement: '',
    nom: '',
    prenom: '',
    date_nais: '',
    adresse: '',
    tel: '',
    email: '',
  });

  useEffect(() => {
    if (employee) {
      // Si un employé est fourni, mettez à jour les données du formulaire
      setEmployeeData({
        departement: employee.departement,
        nom: employee.nom,
        prenom: employee.prenom,
        date_nais: employee.date_nais,
        adresse: employee.adresse,
        tel: employee.tel,
        email: employee.email,
      });
    }
  }, [employee]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEmployeeData({ ...employeeData, [name]: value });
  };

  const handleAddEmployee = () => {

        onSubmit(employeeData);

      // Réinitialiser le formulaire après l'ajout ou la mise à jour
    setEmployeeData({
      departement: '',
      nom: '',
      prenom: '',
      date_nais: '',
      adresse: '',
      tel: '',
      email: '',
    });
  };

  

  return (
    <div style={styles.container}>
      <h2 style={styles.heading}>{employee ? 'Modifier l\'employé' : 'Ajouter un Employé'}</h2>
      <form>
        <div style={styles.formGroup}>
          <label style={styles.label}>
            Département:
            <input
              type="text"
              name="departement"
              style={styles.input}
              onChange={handleChange}
              value={employeeData.departement}
            />
          </label>
        </div>
        {/* Ajouter d'autres champs d'entrée pour d'autres propriétés */}
        <div style={styles.formGroup}>
          <label style={styles.label}>
            Nom:
            <input type="text" name="nom" style={styles.input} onChange={handleChange} value={employeeData.nom} />
          </label>
        </div>
        <div style={styles.formGroup}>
          <label style={styles.label}>
            Prénom:
            <input type="text" name="prenom" style={styles.input} onChange={handleChange} value={employeeData.prenom} />
          </label>
        </div>
        <div style={styles.formGroup}>
          <label style={styles.label}>
            Date de naissance:
            <input type="date" name="date_nais" style={styles.input} onChange={handleChange} value={employeeData.date_nais} />
          </label>
        </div>
        <div style={styles.formGroup}>
          <label style={styles.label}>
            Adresse:
            <input type="text" name="adresse" style={styles.input} onChange={handleChange} value={employeeData.adresse} />
          </label>
        </div>
        <div style={styles.formGroup}>
          <label style={styles.label}>
            Tél:
            <input type="text" name="tel" style={styles.input} onChange={handleChange} value={employeeData.tel} />
          </label>
        </div>
        <div style={styles.formGroup}>
          <label style={styles.label}>
            Email:
            <input type="text" name="email" style={styles.input} onChange={handleChange} value={employeeData.email} />
          </label>
        </div>
  

        <div style={styles.formGroup}>
          <button type="button" style={styles.button} onClick={handleAddEmployee}>
            {employee ? 'Mettre à jour l\'employé' : 'Ajouter Employé'}
          </button>
        </div>
      </form>
    </div>
  );
};

const styles = {
  container: {
    maxWidth: '400px',
    margin: 'auto',
    padding: '20px',
    border: '1px solid #ccc',
    borderRadius: '8px',
    boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',
  },
  heading: {
    textAlign: 'center',
    color: '#333',
  },
  formGroup: {
    marginBottom: '15px',
  },
  label: {
    display: 'block',
    marginBottom: '5px',
    color: '#555',
  },
  input: {
    width: '100%',
    padding: '8px',
    boxSizing: 'border-box',
    borderRadius: '4px',
    border: '1px solid #ccc',
  },
  button: {
    backgroundColor: '#007bff',
    color: '#fff',
    padding: '10px 15px',
    border: 'none',
    borderRadius: '4px',
    cursor: 'pointer',
  },
};

export default EmployeeForm;
