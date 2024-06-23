
import React, { useEffect, useState } from 'react';
import axios from 'axios';

const EntityList = () => {
  const [entities, setEntities] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/entities')
      .then(response => {
        setEntities(response.data);
      })
      .catch(error => {
        console.error('There was an error fetching the data!', error);
      });
  }, []);

  return (
    <div>
      <h1>Entities</h1>
      <ul>
        {entities.map(entity => (
          <li key={entity.id}>{entity.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default EntityList;