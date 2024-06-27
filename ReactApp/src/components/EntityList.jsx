import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const UserComponent = () => {
  const [user, setUser] = useState(null);
  const { id }  = useParams();
  //const numericUserId = parseInt(id, 10); // 10進数の整数に変換 ←別にいらなかった

  console.log(id);
  useEffect(() => {
    const fetchUser = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/${ id }`);
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
