import React from 'react';
import MySnackBar from '../components/MySnackBar';
import MyTable from '../components/MyTable';
import MyStepper from '../components/MyStepper';
import MyTab from '../components/MyTab';
import MyAccordion from '../components/MyAccordion';
import MySkeletonList from '../components/MySkeletonList';
import MyModal from '../components/MyModal';

export default function Components() {
  return (
    <div className="page-container">
      <h2>MySnackBar</h2>
      <MySnackBar message="디지몬 저장 완료!" severity="success" />
      <MySnackBar message="디지몬 삭제 실패!" severity="error" />

      <h2>MyTable</h2>
      <MyTable
        rows={[
          { name: '아구몬', age: 3, grade: 'SSR' },
          { name: '파닥몬', age: 2, grade: 'SR' },
          { name: '가브몬', age: 4, grade: 'R' },
        ]}
      />

      <h2>MyStepper</h2>
      <MyStepper steps={['디지몬 등록', '정보 입력', '등록 완료']} />

      <h2>MyTab</h2>
      <MyTab
        tabs={[
          { label: '소개', content: '이 디지몬은 정의롭고 용감한 성격을 가지고 있습니다.' },
          { label: '능력치', content: '공격력: 95, 방어력: 80, 민첩성: 85' },
          { label: '기원', content: '디지털 월드의 숲에서 태어났습니다.' },
        ]}
      />

      <h2>MyAccordion</h2>
      <MyAccordion
        items={[
          { title: '디지몬의 일상', content: '디지몬은 훈련과 모험으로 하루를 보냅니다.' },
          { title: '디지몬의 특성', content: '진화와 파트너십을 통해 강력한 힘을 발휘합니다.' }
        ]}
      />
<h2>디지몬 팁</h2>
<MyAccordion/>
      <h2>MySkeletonList</h2>
      <MySkeletonList loading={true} count={3} />

      <h2>MyModal</h2>
      <MyModal title="디지몬 정보" content="이 디지몬은 평범하지만 가능성이 무한합니다. 성장하면 궁극체로 진화할 수 있습니다!" />
    </div>
  );
}
