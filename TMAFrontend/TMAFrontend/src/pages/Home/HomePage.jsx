import React, { useEffect, useState } from "react";
import "./HomePage.css";

const HomePage = () => {
  // Use state to keep track of fetched lists
  const [lists, setLists] = useState([]);

  useEffect(() => {
    // Call getLists only if lists are not already fetched
    if (lists.length === 0) {
      getLists();
    }
  }, [lists]); // Include lists in dependency array to prevent unnecessary re-renders

  const getLists = async () => {
    const url = `http://localhost:2911/api/list/get-lists?user_id=1`;
    try {
      const response = await fetch(url, {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (response.ok) {
        const data = await response.json();
        // Update state with fetched lists
        setLists(data);
        console.log(data);
      } else {
        alert("Failed to get lists");
      }
    } catch (error) {
      console.error("Failed to get lists", error);
    }
  };

  const createList = (list) => {
    // Create list elements based on fetched data
    return (
      <div key={list.listId} className="list">
        <h2>{list.list_name}</h2>
      </div>
    );
  };

  const handleAddList = () => {
    window.location.href = "/add-list";
  };

  return (
    <div className="home_background_container">
      <h1>Task Lists</h1>
      <button className="button" onClick={handleAddList}>
        Create New List
      </button>
      <div className="list_container">
        {/* Render lists */}
        {lists.map((list) => createList(list))}
      </div>
    </div>
  );
};

export default HomePage;
