// Sidebar.js
import React, { useState } from 'react';
import './Sidebar.css';

const Sidebar = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggleSidebar = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div className={`sidebar ${isOpen ? 'open' : ''}`}>
      <button className="toggle-btn" onClick={toggleSidebar}>
        Toggle Sidebar
      </button>
      <div className="content">
        {/* Sidebar content goes here */}
        <p>Item 1</p>
        <p>Item 2</p>
        <p>Item 3</p>
      </div>
    </div>
  );
};

export default Sidebar;
