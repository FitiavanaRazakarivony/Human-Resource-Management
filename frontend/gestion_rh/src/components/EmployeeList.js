// EmployeeList.js

import React from 'react';

const EmployeeList = ({ employees, onDelete, onUpdate }) => (
  <ul>
    {employees.map((employee) => (
      <li key={employee.id}>
        {employee.nom} {employee.prenom}
        <button onClick={() => onDelete(employee.id)}>Delete</button>
        <button onClick={() => onUpdate(employee)}>Update</button>
      </li>
    ))}
  </ul>
);

export default EmployeeList;
