import React, { useEffect, useState } from 'react';
import axios from 'axios';


const UserComponent = ({ id }) => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const fetchUser = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/`);
        setUser(response.data);
      } catch (error) {
        console.error("Error fetching the user data:", error);
      }
    };
    fetchUser();
  }, [id]);


  if (!user) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h1>User Information</h1>
      <p>ID: {user.id}</p>
      <p>Name: {user.name}</p>
    </div>
  );
};

export default UserComponent;
