
import React, { useEffect, useState } from 'react';
import axios from 'axios';

const EntityList = () => {
  const [entities, setEntities] = useState([]);

/*  依存配列を空指定しているので
  初回のレンダリング=マウント時に一回のみ起動*/
  useEffect(() => {
    axios.get('http://localhost:8080/api/{id}')
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