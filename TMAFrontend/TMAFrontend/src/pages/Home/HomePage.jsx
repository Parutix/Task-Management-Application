import React from "react";
import "./HomePage.css";

const HomePage = () => {
  const handleAddList = () => {
    window.location.href = "/add-list";
  };

  return (
    <div className="home_background_container">
      <h1>Task Lists</h1>
      <button className="button" onClick={handleAddList}>
        Create New List
      </button>
      <div className="list_container"></div>
    </div>
  );
};

export default HomePage;
