// src/App.js

import React from 'react';
import AddEmployeePage from './components/EmployeComponent';

function App() {
  return (
    <div className="App">
      <AddEmployeePage />
      <main>
        {/* Main content goes here */}
        <h1>Main Content</h1>
        <p>This is the main content area.</p>
      </main>


    </div>
  );
}

export default App;
