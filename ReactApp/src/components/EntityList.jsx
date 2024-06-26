import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {
  useParams,
  useHistory,
  useLocation,
} from 'react-router-dom';


const UserComponent = ({ id }) => {
  const [user, setUser] = useState(null);

  const location = useLocation();
  const nowPagePath = location.pathname;
  // ↑で現在のパスを取得する
  console.log( nowPagePath );
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
