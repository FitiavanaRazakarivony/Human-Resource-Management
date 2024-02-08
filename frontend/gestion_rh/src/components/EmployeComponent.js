import React, { useState, useEffect } from 'react';
import axios from 'axios';
import EmployeeList from './EmployeeList';
import EmployeeForm from './EmployeeForm';
import SendEmail from './SendEmail';

const EmployeComponent = () => {
  const [employees, setEmployees] = useState([]);
  const [isUpdating, setIsUpdating] = useState(false);
  const [selectedEmployee, setSelectedEmployee] = useState(null);
  const [isUpdateFormVisible, setIsUpdateFormVisible] = useState(true);

  useEffect(() => {
    fetchEmployees();
  }, []);

  const fetchEmployees = async () => {
    try {
      const response = await axios.get('http://localhost:3000/api/employees/all');
      setEmployees(response.data);
    } catch (error) {
      console.error('Error fetching employees:', error);
    }
  };

  const addEmployee = async (newEmployee) => {
    try {
      const response = await axios.post('http://localhost:3000/api/employees/add', newEmployee);
      setEmployees([...employees, response.data]);
    } catch (error) {
      console.error('Error adding employee:', error);
    }
  };
  
//   Suppression

  const deleteEmployee = async (id) => {
    try {
      await axios.delete(`http://localhost:3000/api/employees/delete/${id}`);
      setEmployees(employees.filter((employee) => employee.id !== id));
    } catch (error) {
      console.error('Error deleting employee:', error);
    }
  };

  const handleUpdateClick = (employee) => {
    setIsUpdating(true);
    setSelectedEmployee(employee);
    setIsUpdateFormVisible(false); 
  };


  const handleFormSubmit = async (employeeData) => {
    if (isUpdating) {
        handleUpdateEmployee(employeeData);
    } else {
        addEmployee(employeeData);
    }
  };
    // mise a jour

  const handleUpdateEmployee = async (employeeId, updatedData) => {
    try {
      // Envoyer une requête PUT pour mettre à jour l'employé
      const response = await axios.put(`http://localhost:3000/api/employees/update/${employeeId}`, updatedData);

      // Vérifier si la mise à jour a réussi
      if (response.status === 200) {
        // Mettre à jour l'état des employés avec les nouvelles données
        setEmployees((prevEmployees) =>
          prevEmployees.map((employee) =>
            employee.id === employeeId ? { ...employee, ...updatedData } : employee
          )
        );

        // Désélectionner l'employé
        setSelectedEmployee(null);
      } else {
        console.error('Échec de la mise à jour de l\'employé');
      }
      setIsUpdateFormVisible(false);

    } catch (error) {
      console.error('Erreur lors de la mise à jour de l\'employé :', error);
    }
  };

  return (
    <div>
      <h1>Employee Management</h1>

      <EmployeeList employees={employees} onDelete={deleteEmployee} onUpdate={handleUpdateClick} />
      <h2>{isUpdating ? 'Update Employee' : 'Add New Employee'}</h2>
      
          {/* ajout */}
      {isUpdateFormVisible &&(
        <EmployeeForm 
            onSubmit={handleFormSubmit} 
            buttonText={isUpdating ? ' EUpdatemployee' : 'Add Employee'} 
            employee={selectedEmployee} />
      )}

      
      {/* Composant pour la mise à jour d'employé */}
      {selectedEmployee && (
        <EmployeeForm
            employee={selectedEmployee}
            onSubmit={(updatedData) =>
            handleUpdateEmployee(selectedEmployee.id, updatedData)
            }
            buttonText="Mettre à jour l'employé"
        />
        )}
      <SendEmail/>
    </div>
  );
};

export default EmployeComponent;


