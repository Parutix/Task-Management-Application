import React from "react";
import "./AddList.css";

const AddList = () => {
  const checkAddList = () => {
    if (document.getElementById("listNameInput").value === "") {
      return;
    }
  };

  return (
    <div className="add_list_container">
      <h1>Create New List</h1>
      <input type="text" placeholder="List Name" id="listNameInput" />
      <button className="button" onClick={checkAddList}>
        Create
      </button>
    </div>
  );
};

export default AddList;
