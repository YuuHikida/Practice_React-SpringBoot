import React, { useEffect, useState } from 'react';
import axios from 'axios';

const EntityList = ({ id }) => {
  const [entity, setEntity] = useState(null);

 useEffect(() => {
   const fetchData = async () => {
     try {
       const response = await axios.get(`http://localhost:8080/api/${id}`);
       setEntity(response.data);
     } catch (error) {
       console.error('There was an error fetching the data!', error.message);
     }
   };

   fetchData();
 }, [id]);
    console.log(entity.id);
    console.log(entity.name);
  return (
    <div>
      <h1>Entity Details</h1>
      {entity ? (
        <div>
          <p>ID: {entity.id}</p>
          <p>Name: {entity.name}</p>
        </div>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
};

export default EntityList;
